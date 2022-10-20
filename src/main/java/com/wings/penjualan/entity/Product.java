package com.wings.penjualan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
public class Product {

    @Id
    @Column(name="ProductCode", length = 18)
    private String productCode;

    @Column(name="ProductName", length = 30)
    private String productName;

    @Column(name = "Price", length = 6)
    private Double price;

    @Column(name = "Currency", length = 5)
    private String currency;

    @Column(name = "Discount", length = 6)
    private Double discount;

    @Column(name = "Dimension", length = 50)
    private String dimension;

    @Column(name = "Unit", length = 5)
    private String unit;

    @Column(name = "Image")
    private String image;
}
