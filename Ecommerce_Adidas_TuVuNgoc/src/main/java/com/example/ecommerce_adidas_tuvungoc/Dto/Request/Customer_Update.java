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
public class Customer_Update {
    Integer id;
    @NotEmpty(message = "Name cannot is blank")
    @Pattern(regexp = "^[a-zA-Z\\p{L}\\s]+$", message = "Invalid name")
    String name;
    @NotEmpty(message = "phone cannot is blank")
    @Size(min = 1, max = 12, message = "Invalid phone :D")
    String phone;
    @NotEmpty(message = "email cannot is blank")
    @Email(message = "Invalid email")
    String email;
    @NotEmpty(message = "address cannot is blank")
    String address;
    @NotNull(message = "Status cannot null")
    Integer status;
}
