package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "Ram")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ram extends BaseEntity {
    @Column(name = "Capacity")
    String capacity;
    @Column(name = "SpeedBus")
    String speedBus;
    @Column(name = "decription_Ram")
    String decription_Ram;
    @Column(name = "employeeCreate")
    Integer employeeCreate;
    @Column(name = "createDate")
    Date createDate;
    @Column(name = "updateDate")
    Date updateDate;
    @Column(name = "employeeUpdate")
    Date employeeUpdate;
    @Column(name = "status_Ram")
    String status_Ram;
}
