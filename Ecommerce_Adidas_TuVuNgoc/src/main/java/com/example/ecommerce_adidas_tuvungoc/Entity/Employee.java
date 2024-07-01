package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Common.Constants;
import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;

import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "Employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends BaseEntity {
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "name", nullable = false, length = Constants.LENGTH_NAME_MAX)
    String name;
    @Column(name = "email", length = Constants.LENGTH_EMAIL_MAX)
    String email;
    @Column(name = "sex", length = Constants.LENGTH_EMAIL_MAX)
    String sex;
    @Column(name = "phoneNumber", length = Constants.LENGTH_PHONENUMBER_MAX)
    String phoneNumber;
    @Column(name = "dateOfBirth")
    String dateOfBirth;
    @Column(name = "imageProfile")
    String imageProfile;
    @Column(name = "employeeCreate")
    Integer employeeCreate;
    @Column(name = "createDate")
    Date createDate;
    @Column(name = "updateDate")
    Date updateDate;
    @Column(name = "employeeUpdate")
    Date employeeUpdate;
    @Column(name = "status", nullable = false)
    Integer status;
    @ManyToOne
    @JoinColumn(name = "role_id")
    Role role;
}
