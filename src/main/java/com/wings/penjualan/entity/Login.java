package com.wings.penjualan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Logins")
@Data
@NoArgsConstructor
public class Login {

    @Id
    @Column(name="Username", length = 50)
    private String username;

    @Column(name="Password")
    private String password;
}
