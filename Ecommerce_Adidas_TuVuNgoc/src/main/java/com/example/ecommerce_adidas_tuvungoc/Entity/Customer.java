package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Common.Constants;
import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Customer extends BaseEntity {
    @Column(name = "code", unique = true, length = Constants.LENGTH_CODE)
    String code;
    @Column(name = "name", length = Constants.LENGTH_NAME_MAX)
    String name;
    @Column(name = "phone", unique = true, length = 12)
    String phone;
    @Column(name = "email", unique = true, length = Constants.LENGTH_EMAIL_MAX)
    String email;
    @Column(name = "password")
    String password;
    @Column(name = "address", length = Constants.LENGTH_DESCRIPTION)
    String address;
    @Column(name = "status", nullable = false)
    Integer status;

    @Column(name = "session_id")
    String sessionId;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;

}
