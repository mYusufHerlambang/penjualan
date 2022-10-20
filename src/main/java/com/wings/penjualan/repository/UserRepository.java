package com.wings.penjualan.repository;

import com.wings.penjualan.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Login, String> {
}
