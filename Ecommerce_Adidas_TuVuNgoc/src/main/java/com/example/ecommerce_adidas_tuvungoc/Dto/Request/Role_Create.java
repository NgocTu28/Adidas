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
public class Role_Create {
    @NotEmpty(message = "Name cannot is blank")
    private String name;

    @Min(value = 0, message = "Invalid status")
    @Max(value = 1, message = "Invalid status")
    @NotNull(message = "Status cannot is blank")
    private Integer status;
}
