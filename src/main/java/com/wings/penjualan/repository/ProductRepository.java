package com.wings.penjualan.repository;

import com.wings.penjualan.dto.product.ProductDTO;
import com.wings.penjualan.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, String> {


    @Query("""
            SELECT new com.wings.penjualan.dto.product.ProductDTO(pr.productCode, pr.productName, pr.price, pr.discount, pr.image)
            FROM Product pr
            WHERE pr.productName LIKE %:productName%
            """)
    Page<ProductDTO> getAllProduct(Pageable pageable,
                                   @Param("productName") String productName);


    @Query("""
            SELECT new com.wings.penjualan.dto.product.ProductDTO(pr.productCode, pr.productName, pr.price, pr.discount, pr.image,
                pr.dimension, pr.unit)
            FROM Product pr
            WHERE pr.productCode = :productCode
            """)
    ProductDTO getProductById(@Param("productCode") String productCode);
}
