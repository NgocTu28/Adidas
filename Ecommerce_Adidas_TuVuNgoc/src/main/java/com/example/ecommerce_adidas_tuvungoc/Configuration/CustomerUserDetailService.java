package com.example.ecommerce_adidas_tuvungoc.Configuration;

import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerUserDetailService implements UserDetailsService {
    private final Employee_Repository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> employee = employeeRepository.findByUsername(username);
        if (employee.isPresent()) {
            UserDetails userDetails = User.builder()
                    .username(employee.get().getEmail())
                    .password(employee.get().getPassword())
                    .roles(employee.get().getRole().getName())
                    .build();
            return userDetails;
        }
        return (UserDetails) new UsernameNotFoundException("Username not found");
    }


}
