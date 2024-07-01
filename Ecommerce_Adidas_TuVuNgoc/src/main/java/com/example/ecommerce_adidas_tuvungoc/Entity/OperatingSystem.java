package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "OperatingSystem")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatingSystem extends BaseEntity {
    @Column(name = "Capacity")
    String capacity;
    @Column(name = "createDate")
    Date createDate;
    @Column(name = "updateDate")
    Date updateDate;
    @Column(name = "employeeUpdate")
    Date employeeUpdate;
    @Column(name = "status_Ram")
    String status_Ram;
}
