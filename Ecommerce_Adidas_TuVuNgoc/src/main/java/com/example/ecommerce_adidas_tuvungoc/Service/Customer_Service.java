package com.example.ecommerce_adidas_tuvungoc.Service;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Customer_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Customer_Service {
    Page<Customer_Reponse> getAllCustomers(Pageable pageable);

    Page<Customer_Reponse> findByStatus(Integer status, Pageable pageable);

    Customer_Reponse getCustomerById(Integer id);

    List<Customer_Reponse> findByRoleId(Integer idRole);

    boolean existByEmail(String email);

    boolean existByCode(String code);

    boolean existByPhone(String phone);

    boolean existByEmailAndPhone(String email, String phone);

    Customer_Reponse save(Customer_Create customerCreate);

    Customer_Reponse update(Customer_Update customer_update);

    void deleteById(Integer id);

    Customer createCustomerWithSessionId(String sessionId);

    Customer findBySessionId(String sessionId);

    Customer updateForCustomerGuest(Customer_Update update);

    Customer findByIdEntity(Integer id);

    Page<Customer_Reponse> findByNameOrPhoneOrEmailOrCode(String key, Pageable pageable);
}
