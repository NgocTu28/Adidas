package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Common.Constants;
import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;

import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "Employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends BaseEntity {
    @Column(name = "username", unique = true, nullable = false, length = Constants.LENGTH_USERNAME_MAX)
    String username;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "name", nullable = false, length = Constants.LENGTH_NAME_MAX)
    String name;
    @Column(name = "email", length = Constants.LENGTH_EMAIL_MAX)
    String email;
    @Column(name = "status", nullable = false)
    Integer status;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
