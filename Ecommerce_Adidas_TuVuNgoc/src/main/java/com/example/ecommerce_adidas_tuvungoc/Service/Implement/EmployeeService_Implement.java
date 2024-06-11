package com.example.ecommerce_adidas_tuvungoc.Service.Implement;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employe_Request;
import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import com.example.ecommerce_adidas_tuvungoc.Service.Employee_Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService_Implement implements Employee_Service {
    private final Employee_Repository employeeRepository;

    @Override
    public String createEmployee(Employe_Request employeRequest) {
        if(employeeRepository.findByEmailEmployee(employeRequest.getEmailEmployee())){
            return 
        }
        return null;
    }
}
