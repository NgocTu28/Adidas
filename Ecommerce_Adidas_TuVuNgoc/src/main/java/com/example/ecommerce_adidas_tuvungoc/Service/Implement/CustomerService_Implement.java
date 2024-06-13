package com.example.ecommerce_adidas_tuvungoc.Service.Implement;

import com.example.ecommerce_adidas_tuvungoc.Model.Customer;
import com.example.ecommerce_adidas_tuvungoc.Repository.Customer_Repository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService_Implement implements UserDetailsService {
    @Autowired
    private Customer_Repository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmailCustomer(username);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer not found");
        }
        return new org.springframework.security.core.userdetails.User(
                customer.getUsername(),
                customer.getPassword(),
                new ArrayList<>()
        );
    }
}

