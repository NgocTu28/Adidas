package com.example.ecommerce_adidas_tuvungoc.Repository;

import com.example.ecommerce_adidas_tuvungoc.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Customer_Repository {
    @Query(value = "SELECT c FROM Customer c WHERE c.email = :email")
    Customer findByEmailCustomer(@Param("email") String email);
}
