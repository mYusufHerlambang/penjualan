package com.wings.penjualan.controller;

import com.wings.penjualan.dto.product.ProductDTO;
import com.wings.penjualan.entity.Product;
import com.wings.penjualan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProduct(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "") String productName,
                              Model model){

        Pageable pageable = PageRequest.of(page-1, 10, Sort.by("id"));

        Page<ProductDTO> products =  productService.getProducts(pageable, productName);

//        System.out.println("ini product ctrl = "+ products.getContent());

        model.addAttribute("productGrid", products.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        model.addAttribute("breadCrumbs", "Product List Page");
        model.addAttribute("productName", productName);

        return "product/product-list";
    }

    @GetMapping("/detail")
    public String productDetail(@RequestParam(required = true) String productCode,
                                Model model){

        ProductDTO productById = productService.getProductById(productCode);

        model.addAttribute("product", productById);
        model.addAttribute("breadCrumbs", "Product Detail");

        return "product/product-detail";
    }
}
