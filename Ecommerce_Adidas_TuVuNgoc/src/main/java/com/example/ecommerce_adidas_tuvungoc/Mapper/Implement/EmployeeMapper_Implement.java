package com.example.ecommerce_adidas_tuvungoc.Mapper.Implement;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Employee_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import com.example.ecommerce_adidas_tuvungoc.Mapper.Employees_Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper_Implement implements Employees_Mapper {

    @Override
    public Employee createEmployeeToEmployee(Employee_Create create) {
        Employee employee = Employee.builder()
                .name(create.getUsername())
                .name(create.getName().trim())
                .email(create.getEmail().trim())
                .password(create.getPassword())
                .status(create.getStatus())
                .build();
        return employee;
    }

    @Override
    public Employee updateEmployeeToEmployee(Employee_Update employeeUpdate, Employee employee) {
        employee.setName(employeeUpdate.getName());
        employee.setStatus(employeeUpdate.getStatus());
        employee.setEmail(employeeUpdate.getEmail());
        return employee;
    }

    @Override
    public Employee_Reponse employeeEntityToEmployeeReponse(Employee employee) {
        Employee_Reponse response = Employee_Reponse.builder()
                .name(employee.getName())
                .email(employee.getEmail())
                .id(employee.getId())
                .status(employee.getStatus())
                .createAt(String.valueOf(employee.getCreateAt()))
                .createBy(employee.getCreateBy())
                .modifyAt(String.valueOf(employee.getModifyAt()))
                .modifyBy(employee.getModifyBy())
                .role(employee.getRole().getName())
                .build();
        response.convertTime();
        return response;
    }

    @Override
    public Page<Employee_Reponse> listEmployeeEntityToEmployeeReponsePage(Page<Employee> employeePage) {
        List<Employee_Reponse> responses = employeePage.getContent()
                .stream().map(this::employeeEntityToEmployeeReponse).collect(Collectors.toList());
        return new PageImpl<>(responses, employeePage.getPageable(), employeePage.getTotalElements());
    }
}
