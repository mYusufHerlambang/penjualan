package com.wings.penjualan.helper;

import com.wings.penjualan.entity.Product;
import com.wings.penjualan.entity.Transaction;
import com.wings.penjualan.entity.TransactionDetail;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {

    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }

    public static List<Transaction> listTrx;
    static {
        listTrx = new ArrayList<Transaction>();
    }
}
