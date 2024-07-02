package com.example.ecommerce_adidas_tuvungoc.Mapper;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Employee_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import org.springframework.data.domain.Page;

public interface Employees_Mapper {
    Employee createEmployeeToEmployee(Employee_Create employeeCreate);

    Employee updateEmployeeToEmployee(Employee_Update employeeUpdate, Employee employee);

    Employee_Reponse employeeEntityToEmployeeReponse(Employee employee);

    Page<Employee_Reponse> listEmployeeEntityToEmployeeReponsePage(Page<Employee> employeePage);
}
