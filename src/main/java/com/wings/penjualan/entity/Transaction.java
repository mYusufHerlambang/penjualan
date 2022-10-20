package com.wings.penjualan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increment
    @Column(name="Id")
    private Long id;

    @Column(name = "InvoiceNumber")
    private String invoice;

    @Column(name = "Username", length = 50)
    private String username;

    @ManyToOne
    @JoinColumn(name = "Username", insertable=false, updatable=false)
    private Login login;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "TransactionDate")
    private LocalDate trxDate;

    @Column(name = "TransactionStatus")
    private String trxStatus;

    @Column(name = "Total")
    private Double total;

    public Transaction(String invoice, String username, LocalDate trxDate, String trxStatus) {
        this.invoice = invoice;
        this.username = username;
        this.trxDate = trxDate;
        this.trxStatus = trxStatus;
    }
}
