package com.example.ecommerce_adidas_tuvungoc.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee_Repository {
    @Query(value = "SELECT e FROM Employees e WHERE e.emailEmployee = :email")
    Boolean findByEmailEmployee(@Param("email") String email);
}
