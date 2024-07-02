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
public class Employee_Reponse {
    Integer id;
    String username;
    String email;
    String role;
    String createAt;
    String modifyAt;
    String createBy;
    String modifyBy;
    String name;
    Integer status;

    public void convertTime() {
        this.createAt = ConvertTime.convert(this.createAt);
        this.modifyAt = ConvertTime.convert(this.modifyAt);
    }
}
