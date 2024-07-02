package com.example.ecommerce_adidas_tuvungoc.Service;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Employee_Reponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface Employee_Service {
    Employee_Reponse add(Employee_Create employeeCreate);

    Employee_Reponse update(Employee_Update employeeUpdate);

    void delete(Integer id);

    Page<Employee_Reponse> getAll(Pageable pageable);

    Page<Employee_Reponse> findByStatus(Pageable pageable, Integer status);

    boolean isExistByUsername(String username);

    Employee_Reponse findById(Integer id);

    boolean existByEmail(String email);
}
