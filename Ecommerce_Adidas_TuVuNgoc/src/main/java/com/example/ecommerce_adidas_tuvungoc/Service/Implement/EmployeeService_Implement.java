package com.example.ecommerce_adidas_tuvungoc.Service.Implement;


import com.example.ecommerce_adidas_tuvungoc.Model.Employees;
import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService_Implement implements UserDetailsService {
    private final Employee_Repository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employees employees = employeeRepository.findByEmailEmployee(username).get();
        if(employees == null){
            throw new UsernameNotFoundException("Invail username or password.");
        }
        List<GrantedAuthority> authorities = employees.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new User(employees.getEmailEmployee(),employees.getPasswordEmployee(), authorities);

    }
}
