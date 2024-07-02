package com.example.ecommerce_adidas_tuvungoc.Mapper;


import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Customer_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Customer_Mapper {
    Customer createToEntity(Customer_Create create);

    Customer updateToEntity(Customer_Update update, Customer customer);

    Customer_Reponse entityToResponse(Customer customer);

    Page<Customer_Reponse> listEntityToListResponse(Page<Customer> customerPage);

    List<Customer_Reponse> listEntityToListResponse(List<Customer> customerList);
}
