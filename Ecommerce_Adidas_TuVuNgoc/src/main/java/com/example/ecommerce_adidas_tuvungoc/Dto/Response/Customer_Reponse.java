package com.example.ecommerce_adidas_tuvungoc.Dto.Response;

import com.example.ecommerce_adidas_tuvungoc.Common.ConvertTime;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer_Reponse {
    Integer id;
    String code;
    String name;
    String phone;
    String email;
    String address;
    Integer status;
    String role;
    String createAt;
    String modifyAt;
    String createBy;
    String modifyBy;

    public void convertTime() {
        this.createAt = ConvertTime.convert(this.createAt);
        this.modifyAt = ConvertTime.convert(this.modifyAt);
    }
}
