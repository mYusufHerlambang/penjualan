package com.wings.penjualan.service;

import com.wings.penjualan.dto.product.ProductDTO;
import com.wings.penjualan.entity.Product;
import com.wings.penjualan.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductDTO> getProducts(Pageable pageable, String productName) {

        Page<ProductDTO> productDTOPage = productRepository.getAllProduct(pageable, productName);

//        System.out.println("ini products dari repo = "+productDTOPage);
        return productDTOPage;
    }

    @Override
    public ProductDTO getProductById(String productCode) {
        ProductDTO product = productRepository.getProductById(productCode);

        return product;
    }

    @Override
    public Product getById(String productCode) {
        Optional<Product> productOptional = productRepository.findById(productCode);

        Product product = null;

        if (productOptional.isPresent()){
            product = productOptional.get();
        }

        return product;
    }
}
