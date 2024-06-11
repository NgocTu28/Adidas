package com.example.ecommerce_adidas_tuvungoc.Dto.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer_Request {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String phoneNumber;
    private String address;
    private String status;
}
