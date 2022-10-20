package com.wings.penjualan.repository;

import com.wings.penjualan.dto.trxDetail.TrxDetailDTO;
import com.wings.penjualan.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Long> {

    @Query("""
            SELECT new com.wings.penjualan.dto.trxDetail.TrxDetailDTO(prod.productName, prod.unit, prod.image)
            From TransactionDetail trxDet
            JOIN trxDet.product prod
            JOIN trxDet.transaction trx
            WHERE trx.username = :username
                AND trx.trxStatus = :status
            """)
    List<TrxDetailDTO> findCartByUserLogin(String username,
                                           String status);
}
