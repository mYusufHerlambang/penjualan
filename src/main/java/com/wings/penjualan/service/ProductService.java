package com.wings.penjualan.service;

import com.wings.penjualan.dto.product.ProductDTO;
import com.wings.penjualan.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductDTO> getProducts(Pageable pageable, String productName);

    ProductDTO getProductById(String productCode);

    Product getById(String productCode);
}
