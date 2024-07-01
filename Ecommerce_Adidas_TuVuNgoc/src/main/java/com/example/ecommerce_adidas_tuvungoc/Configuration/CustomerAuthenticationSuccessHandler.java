package com.example.ecommerce_adidas_tuvungoc.Configuration;

import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import com.example.ecommerce_adidas_tuvungoc.Repository.Customer_Repository;
import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomerAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final Customer_Repository customerRepository;
    private final Employee_Repository employeeRepository;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String name = authentication.getName();
        Employee employee = (Employee) employeeRepository.findByUsername(name).orElse(null);
        Customer customer = customerRepository.findByEmail(name).orElse(null);
        HttpSession session = request.getSession();
        if (customer != null) {
            session.setAttribute("o", customer);
            response.sendRedirect("/category");
        }else if (employee != null){
            session.setAttribute("o", employee);
            response.sendRedirect("/home/products");
        }
    }
}
