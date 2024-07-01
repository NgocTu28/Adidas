package com.example.ecommerce_adidas_tuvungoc.Configuration;

import com.example.ecommerce_adidas_tuvungoc.Configuration.User.User_Service;
import lombok.AllArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor
public class Security_Configuration {
    private final CustomerAuthenticationSuccessHandler customerAuthenticationSuccessHandler;
    private final CustomerAccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(User_Service userService, PasswordEncoder passwordEncoder
    ) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                .requestMatchers("/role/**").hasRole("ADMIN")
                .anyRequest().permitAll()
        ).formLogin(formLogin -> formLogin
                .loginPage("/login")
                .successHandler(customerAuthenticationSuccessHandler)
                .loginProcessingUrl("/login")
                .permitAll()
        ).logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
        ).exceptionHandling(ex -> ex
                .accessDeniedHandler(accessDeniedHandler)
        ).csrf(csrf -> csrf.disable());
        return http.build();
    }
}
