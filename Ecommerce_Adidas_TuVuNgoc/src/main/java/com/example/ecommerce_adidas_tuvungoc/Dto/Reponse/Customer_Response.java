package com.example.ecommerce_adidas_tuvungoc.Dto.Reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Customer_Response {
    private String password;
    private String email;
}
