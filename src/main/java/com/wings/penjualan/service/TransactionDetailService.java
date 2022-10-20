package com.wings.penjualan.service;

import com.wings.penjualan.dto.trxDetail.TrxDetailDTO;
import com.wings.penjualan.entity.Product;
import com.wings.penjualan.entity.Transaction;
import com.wings.penjualan.entity.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {


    void addTrxDetail(Product product, Transaction transaction);

    List<TrxDetailDTO> getCart(String username);
}
