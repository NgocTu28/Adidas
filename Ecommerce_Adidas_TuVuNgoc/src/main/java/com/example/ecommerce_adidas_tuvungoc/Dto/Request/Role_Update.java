package com.example.ecommerce_adidas_tuvungoc.Dto.Request;

import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role_Update {
    Integer id;
    @NotEmpty(message = "Khong de trong ten")
    String name;

    @Min(value = 0, message = "Trang thai khong hop le")
    @Max(value = 1, message = "Trang thai khong hop le")
    @NotNull(message = "Khong de trong trang thai")
    Integer status;
}