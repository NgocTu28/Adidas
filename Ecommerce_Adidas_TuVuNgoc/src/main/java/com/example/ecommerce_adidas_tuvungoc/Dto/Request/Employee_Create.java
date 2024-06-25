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
public class Employee_Create {
    @NotBlank(message = "Username cannot blank")
    @Size(min = 6, max = 16, message = "username required 8-16 characters")
    String username;
    @NotBlank(message = "Password cannot bank")
    @Size(min = 8, max = 16, message = "Password required 8-16 characters")
    String password;
    @NotBlank(message = "Password cannot bank")
    @Size(min = 8, max = 16, message = "Password required 8-16 characters")
    String passwordComfirm;
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
