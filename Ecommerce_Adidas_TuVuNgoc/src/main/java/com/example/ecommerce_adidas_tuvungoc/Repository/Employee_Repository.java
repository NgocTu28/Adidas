package com.example.ecommerce_adidas_tuvungoc.Repository;

import com.example.ecommerce_adidas_tuvungoc.Model.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Employee_Repository {
    @Query(value = "SELECT e FROM Employees e WHERE e.emailEmployee = :email")
    Optional<Employees> findByEmailEmployee(@Param("email") String email);
}
