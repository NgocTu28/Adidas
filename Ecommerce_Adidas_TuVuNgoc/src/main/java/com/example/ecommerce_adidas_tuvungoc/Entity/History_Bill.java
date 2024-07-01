package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Common.Constants;
import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "History_Bill")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class History_Bill extends BaseEntity {
    @Column(name = "dicription_Customer",length = Constants.LENGTH_DESCRIPTION)
    String dicriptionCusTomer;
    @Column(name = "dicription_Employee",length = Constants.LENGTH_DESCRIPTION)
    String dicriptionEmployee;
    @ManyToOne
    @JoinColumn(name = "Employee")
    Employee employee;
    @ManyToOne
    @JoinColumn(name = "Customer")
    Customer customer;
}
