package com.example.ecommerce_adidas_tuvungoc.Dto.Reponse;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee_Response {
    private String emailEmployee;
    private String passwordEmployee;
}
