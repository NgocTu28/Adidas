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
public class Employee_Update {
    Long id;
    @NotBlank(message = "name cannot bank")
    String name;
    @NotBlank(message = "email cannot bank")
    String email;
    @NotNull(message = "Status cannot is blank")
    @Min(value = 0, message = "Status is invalid")
    @Max(value = 1, message = "Status is invalid")
    Integer status;
    @NotNull(message = "Status cannot is blank")
    Long idRole;
}
