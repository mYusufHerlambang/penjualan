package com.wings.penjualan.dto.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDTO {
    private String productCode;

    private String productName;

    private Double price;

    private Double discount;

    private String image;

    private String dimension;

    private String unit;

    //allproduct
    public ProductDTO(String productCode, String productName, Double price, Double discount, String image) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    //productById
    public ProductDTO(String productCode, String productName, Double price, Double discount, String image, String dimension, String unit) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.dimension = dimension;
        this.unit = unit;
    }

    public Double priceAfterDiscount(){

        if (this.discount == null) {
            this.discount = 0.0;
        }

        Double totalDiscount = (this.price * this.discount) / 100;
        Double priceAfter = this.price - totalDiscount;

        return priceAfter;
    }

}
