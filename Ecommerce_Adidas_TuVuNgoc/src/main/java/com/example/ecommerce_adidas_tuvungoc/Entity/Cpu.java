package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "Cpu")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cpu extends BaseEntity {
    @Column(name = "version_Cpu")
    String versionCpu;
    @Column(name = "")
    String speedBus;
    @Column(name = "producer_Cpu")
    String producerCpu;
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
