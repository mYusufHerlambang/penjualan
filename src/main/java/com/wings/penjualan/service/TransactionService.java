package com.wings.penjualan.service;

import com.wings.penjualan.entity.Transaction;

import java.time.LocalDate;

public interface TransactionService {
    Transaction addTransaction(String username, LocalDate date, String status);
}
