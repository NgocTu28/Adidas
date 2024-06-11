package com.example.ecommerce_adidas_tuvungoc.Dto.Request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@Builder
public class Employe_Request {
    private String nameEmployee;
    private String numberIdentificationEmployee;
    private String emailEmployee;
    private String phoneNumberEmployee;
    private String passwordEmployee;
    private Date dateOfBirthEmployee;
    private LocalDate startWorkEmployee;
    private Integer roleEmployee;
    private Integer statusEmployee;
}
