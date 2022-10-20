package com.wings.penjualan.helper;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Helper {

    public static String formatRupiah(Double value){
        Locale indonesia = new Locale("id", "ID");
        String indoFormat = NumberFormat.getCurrencyInstance(indonesia).format(value);
        return indoFormat;
    }

    public static String formatInvoice(String username, LocalDate date){

        String strDate = date.toString();

        String invoiceNumber = "TRX-"+username.concat(strDate);

        return invoiceNumber;
    }


}
