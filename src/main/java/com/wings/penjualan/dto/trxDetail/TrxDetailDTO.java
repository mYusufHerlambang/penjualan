package com.wings.penjualan.dto.trxDetail;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrxDetailDTO {
    private String productName;
    private String unit;
    private String image;


    public TrxDetailDTO(String productName, String unit, String image) {
        this.productName = productName;
        this.unit = unit;
        this.image = image;
    }
}
