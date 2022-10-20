package com.wings.penjualan.service;

import com.wings.penjualan.dto.trxDetail.TrxDetailDTO;
import com.wings.penjualan.entity.Product;
import com.wings.penjualan.entity.Transaction;
import com.wings.penjualan.entity.TransactionDetail;
import com.wings.penjualan.repository.TransactionDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionDetailServiceImpl implements TransactionDetailService{

    @Autowired
    private TransactionDetailRepository trxDetailRepo;

    @Override
    public void addTrxDetail(Product product, Transaction transaction) {
        TransactionDetail trxDetail = new TransactionDetail(
                product.getProductCode(),
                transaction.getId(),
                product.getPrice()
        );

        trxDetailRepo.save(trxDetail);
    }

    @Override
    public List<TrxDetailDTO> getCart(String username) {
        String status = "pending";

        List<TrxDetailDTO> transactionDetails = trxDetailRepo.findCartByUserLogin(username, status);

        return transactionDetails;
    }
}
