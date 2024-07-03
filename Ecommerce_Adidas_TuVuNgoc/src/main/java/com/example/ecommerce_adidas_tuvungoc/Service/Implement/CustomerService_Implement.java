package com.example.ecommerce_adidas_tuvungoc.Service.Implement;

import com.example.ecommerce_adidas_tuvungoc.Common.GenerateCode;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Customer_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import com.example.ecommerce_adidas_tuvungoc.Entity.Role;
import com.example.ecommerce_adidas_tuvungoc.Mapper.Customer_Mapper;
import com.example.ecommerce_adidas_tuvungoc.Repository.Customer_Repository;
import com.example.ecommerce_adidas_tuvungoc.Repository.Role_Repository;
import com.example.ecommerce_adidas_tuvungoc.Service.Customer_Service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Primary
@AllArgsConstructor
public class CustomerService_Implement implements Customer_Service {
    private final Customer_Repository customerRepository;
    private final GenerateCode generateCode;
    @Qualifier("customer_Mapper")
    private final Customer_Mapper customerMapper;
    private final PasswordEncoder passwordEncoder;
    private final Role_Repository roleRepository;
    @Override
    public Page<Customer_Reponse> getAllCustomers(Pageable pageable) {
        return customerMapper.listEntityToListResponse(customerRepository.findAll(pageable));
    }

    @Override
    public Page<Customer_Reponse> findByStatus(Integer status, Pageable pageable) {
        return customerMapper.listEntityToListResponse(customerRepository.findByStatus(pageable, status));
    }

    @Override
    public Customer_Reponse getCustomerById(Integer id) {
        return customerMapper.entityToResponse(customerRepository.findById(id).orElse(null));
    }

    @Override
    public List<Customer_Reponse> findByRoleId(Integer idRole) {
        return customerMapper.listEntityToListResponse(customerRepository.findByRoleId(idRole));
    }

    @Override
    public boolean existByEmail(String email) {
        return customerRepository.existsByEmail(email.trim());
    }

    @Override
    public boolean existByCode(String code) {
        return customerRepository.existsByCode(code.trim());
    }

    @Override
    public boolean existByPhone(String phone) {
        return customerRepository.existsByPhone(phone.trim());
    }

    @Override
    public boolean existByEmailAndPhone(String email, String phone) {
        if(customerRepository.findByPhoneNumberAndEmail(email,phone) == null) {
            return true;
        }
        return false;
    }

    @Override
    public Customer_Reponse save(Customer_Create customerCreate) {
        Customer customer = customerMapper.createToEntity(customerCreate);
        do {
            customer.setCode(generateCode.generateCode(GenerateCode.CUSTOMER_PREFIX));
        }while (customerRepository.existsByCode(customer.getCode()));
            customer.setPassword(passwordEncoder.encode(customer.getPassword()));
            customer.setRole(roleRepository.findByName("CUSTOMER").orElse(null));
        return customerMapper.entityToResponse(customerRepository.save(customer));
    }

    @Override
    public Customer_Reponse update(Customer_Update customer_update) {
        Optional<Customer> customer = customerRepository.findById(customer_update.getId());
        if(customer.isPresent()) {
            Customer isEntity = customerMapper.updateToEntity(customer_update, customer.get());
            return customerMapper.entityToResponse(customerRepository.save(isEntity));
        }
        return null;
    }

    @Override
    public void deleteById(Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        }
    }

    @Override
    public Customer createCustomerWithSessionId(String sessionId) {
        Role role = roleRepository.findByName("CUSTOMER").orElse(null);
        Customer customer = Customer.builder()
                .role(role)
                .status(1)
                .name("GUEST")
                .sessionId(sessionId.trim())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Customer findBySessionId(String sessionId) {
        return customerRepository.findBySessionId(sessionId);
    }

    @Override
    public Customer updateForCustomerGuest(Customer_Update update) {
        return null;
    }

    @Override
    public Optional<Customer> findByIdCustomer(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer_Reponse findById(Integer id) {
        return customerMapper.entityToResponse(customerRepository.findById(id).orElse(null));
    }
}
