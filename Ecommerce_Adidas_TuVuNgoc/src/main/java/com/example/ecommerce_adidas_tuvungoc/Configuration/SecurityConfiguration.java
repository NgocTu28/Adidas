package com.example.ecommerce_adidas_tuvungoc.Configuration;

import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import com.example.ecommerce_adidas_tuvungoc.Service.Customer_Service;
import com.example.ecommerce_adidas_tuvungoc.Service.Employee_Service;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration{
    private Employee_Service employeeService;
    private Customer_Service customerService;
    private PasswordEncoder passwordEncoder;





    @Bean DaoAuthenticationProvider employeeAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(employeeService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean DaoAuthenticationProvider customerAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService((UserDetailsService) customerService);
        provider.setPasswordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
