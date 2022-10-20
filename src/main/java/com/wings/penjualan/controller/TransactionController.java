package com.wings.penjualan.controller;

import com.wings.penjualan.dto.trxDetail.TrxDetailDTO;
import com.wings.penjualan.entity.Product;
import com.wings.penjualan.entity.Transaction;
import com.wings.penjualan.entity.TransactionDetail;
import com.wings.penjualan.helper.GlobalData;
import com.wings.penjualan.helper.Helper;
import com.wings.penjualan.service.ProductService;
import com.wings.penjualan.service.TransactionDetailService;
import com.wings.penjualan.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService trxService;

    @Autowired
    private TransactionDetailService trxDetailService;

    @Autowired
    private ProductService productService;

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam String productCode){

        Product product = productService.getById(productCode);

        GlobalData.cart.add(product);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        Double total = GlobalData.cart.stream().mapToDouble(Product :: getPrice).sum();
        LocalDate date = LocalDate.now();
        String status = "pending";

        Transaction transaction = trxService.addTransaction(username, date, status);
//        GlobalData.listTrx.add(transaction);
//        var listTransaction = GlobalData.listTrx.stream().toList();
//
//        var trxByUsername = listTransaction.stream()
//                .filter(trx -> trx.getUsername().equals(username));
//
//        System.out.println("ini trx punya "+username+" = "+trxByUsername.toList());

//        var size = trxByUsername.toList().size();
//        Double total = trxByUsername.toList().get(size -1).getTotal();
////
//        System.out.println("ini total "+username +" = "+ total);
        var listProduct =  GlobalData.cart.stream().toList();

        trxDetailService.addTrxDetail(product, transaction);

        return "redirect:/product/list";
    }

    @GetMapping("productDetail/addToCart")
    public String productDetailAddToCart(@RequestParam String productCode){

        Product product = productService.getById(productCode);
//        System.out.println("ini product button buy = "+product);

        GlobalData.cart.add(product);

//        System.out.println("ini size globalData = "+ GlobalData.cart.size());
//        System.out.println("ini data = "+GlobalData.cart.stream().toList());
        return "redirect:/product/list";
    }

    @GetMapping("/cart")
    public String cart(Model model){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        List<TrxDetailDTO> carts = trxDetailService.getCart(username);

        System.out.println("ini trxDetail = "+carts.stream().toList());

        if (carts.size() != 0){
            model.addAttribute("carts", carts);
            model.addAttribute("breadCrumbs", "Cart Page");

            return "transaction/cart";
        } else {

            model.addAttribute("breadCrumbs", "Cart Page");

            return "transaction/cart-null";
        }
    }


}
