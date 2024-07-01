package com.example.ecommerce_adidas_tuvungoc.Entity;

import com.example.ecommerce_adidas_tuvungoc.Entity.Base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Table(name = "Color")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Color extends BaseEntity {
    @Column(name = "createDate")
    Date createDate;
    @Column(name = "updateDate")
    Date updateDate;
    @Column(name = "employeeUpdate")
    Date employeeUpdate;
    @Column(name = "status_Ram")
    String status_Ram;
}
