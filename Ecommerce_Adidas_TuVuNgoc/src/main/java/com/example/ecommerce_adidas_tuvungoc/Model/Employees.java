package com.example.ecommerce_adidas_tuvungoc.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Employees")
@Getter
@Setter
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name_Employee")
    private String nameEmployee;
    @Column(name = "numberIdentification_Employee")
    private String numberIdentificationEmployee;
    @Column(name = "email_Employee")
    private String emailEmployee;
    @Column(name = "phoneNumber_Employee")
    private String phoneNumberEmployee;
    @Column(name = "password_Employee")
    private String passwordEmployee;
    @Column(name = "dateOfBirth_Employee")
    private Date dateOfBirthEmployee;
    @Column(name = "startWork_Employee")
    private LocalDate startWorkEmployee;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Employee_Roles", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "role")
    private List<String> roles;
    @Column(name = "status_Employee")
    private Integer statusEmployee;
}
