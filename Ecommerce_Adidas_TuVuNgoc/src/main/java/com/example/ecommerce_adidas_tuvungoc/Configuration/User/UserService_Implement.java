package com.example.ecommerce_adidas_tuvungoc.Configuration.User;

import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import com.example.ecommerce_adidas_tuvungoc.Repository.Customer_Repository;
import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserService_Implement implements User_Service {
    private final Customer_Repository customerRepository;
    private final Employee_Repository employeeRepository;

    @Override
    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username.trim()).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username.trim()).orElse(null);
        Employee employee = employeeRepository.findByUsername(username.trim()).orElse(null);
        if (employee != null) {
            return User.builder()
                    .username(employee.getEmail())
                    .password(employee.getPassword())
                    .roles(employee.getRole().getName())
                    .build();
        } else if (customer != null) {
            return User.builder()
                    .username(customer.getEmail())
                    .password(customer.getPassword())
                    .roles(customer.getRole().getName())
                    .build();
        } else if (employee == null && customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return null;
    }
}
