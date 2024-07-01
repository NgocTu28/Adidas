package com.example.ecommerce_adidas_tuvungoc.Configuration.User;

import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service("userService")
@Component
public interface User_Service extends UserDetailsService {
    Employee findByUsername(String username);
}
