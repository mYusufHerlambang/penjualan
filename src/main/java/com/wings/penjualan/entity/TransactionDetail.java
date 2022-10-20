package com.wings.penjualan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TransactionDetails")
public class TransactionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    @Column(name="ProductCode", length = 18)
    private String productCode;

    @ManyToOne
    @JoinColumn(name = "ProductCode", insertable=false, updatable=false)
    private Product product;

    @Column(name = "TransactionId")
    private Long trxId;

    @ManyToOne
    @JoinColumn(name = "TransactionId", insertable=false, updatable=false)
    private Transaction transaction;

    @Column(name = "Quantity", length = 6)
    private Integer qty;

    @Column(name = "subTotal", length = 10)
    private Double subTotal;

    public TransactionDetail(String productCode, Long trxId, Double subTotal) {
        this.productCode = productCode;
        this.trxId = trxId;
        this.subTotal = subTotal;
    }
}
