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
public class Role_Reponse {
    Integer id;
    String name;
    Integer status;
    String createAt;
    String modifyAt;
    String createBy;
    String modifyBy;

    public void convertTime() {
        this.createAt = ConvertTime.convert(this.createAt);
        this.modifyAt = ConvertTime.convert(this.modifyAt);
    }
}
