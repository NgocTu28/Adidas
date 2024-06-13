package com.example.ecommerce_adidas_tuvungoc.Service;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employe_Request;
import com.example.ecommerce_adidas_tuvungoc.Model.Employees;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface Employee_Service extends UserDetailsService {
     String createEmployee(Employe_Request employeRequest);
    Employees loadEmployeeByEmail(String email);
}
