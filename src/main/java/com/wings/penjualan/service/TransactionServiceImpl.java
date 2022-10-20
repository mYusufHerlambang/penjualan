package com.wings.penjualan.service;

import com.wings.penjualan.entity.Product;
import com.wings.penjualan.entity.Transaction;
import com.wings.penjualan.helper.GlobalData;
import com.wings.penjualan.helper.Helper;
import com.wings.penjualan.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository trxRepository;

    @Override
    public Transaction addTransaction(String username, LocalDate date, String status) {

        Transaction newTransaction = new Transaction(
                Helper.formatInvoice(username, date),
                username,
                date,
                status
        );

        trxRepository.save(newTransaction);

        return newTransaction;
    }
}
