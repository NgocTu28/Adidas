package com.example.ecommerce_adidas_tuvungoc.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customer")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
}
