package com.example.ecommerce_adidas_tuvungoc.Mapper.Implement;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Customer_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import com.example.ecommerce_adidas_tuvungoc.Mapper.Customer_Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CustomerMapper_Implement implements Customer_Mapper {
    @Override
    public Customer createToEntity(Customer_Create create) {
        Customer customer = Customer.builder()
                .email(create.getEmail().trim())
                .phone(create.getPhone().trim())
                .name(create.getName().trim())
                .address(create.getAddress().trim())
                .password(create.getPassword().trim())
                .status(create.getStatus())
                .build();
        return customer;
    }

    @Override
    public Customer updateToEntity(Customer_Update update, Customer customer) {
        customer.setName(update.getName());
        customer.setStatus(update.getStatus());
        customer.setAddress(update.getAddress());
        customer.setEmail(update.getEmail());
        customer.setPhone(update.getPhone());
        return customer;
    }

    @Override
    public Customer_Reponse entityToResponse(Customer customer) {
        Customer_Reponse response = Customer_Reponse.builder()
                .id(customer.getId())
                .code(customer.getCode())
                .name(customer.getName())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .address(customer.getAddress())
                .status(customer.getStatus())
                .role(customer.getRole().getName())
                .createAt(String.valueOf(customer.getCreateAt()))
                .modifyAt(String.valueOf(customer.getModifyAt()))
                .createBy(customer.getCreateBy())
                .modifyBy(customer.getModifyBy())
                .build();
        response.convertTime();
        return response;
    }

    @Override
    public Page<Customer_Reponse> listEntityToListResponse(Page<Customer> customerPage) {
        List<Customer_Reponse> response = customerPage.getContent().stream()
                .map(this::entityToResponse).collect(Collectors.toList());
        return new PageImpl<>(response, customerPage.getPageable(), customerPage.getTotalElements());
    }

    @Override
    public List<Customer_Reponse> listEntityToListResponse(List<Customer> customerList) {
        return customerList.stream().map(this::entityToResponse).collect(Collectors.toList());
    }
}
