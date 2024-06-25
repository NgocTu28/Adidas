package com.example.ecommerce_adidas_tuvungoc.Entity.Base;

import com.example.ecommerce_adidas_tuvungoc.Util.TimeAuto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@MappedSuperclass
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(TimeAuto.class)
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id", updatable = false, insertable = false)
    Long id;
    @Column(name = "create_at", updatable = false)
    Long createAt;
    @Column(name = "modify_at")
    Long modifyAt;
    @Column(name = "create_by")
    String createBy;
    @Column(name = "modify_by")
    String modifyBy;
}
