package com.example.ecommerce_adidas_tuvungoc.Model;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
public enum Role {
    CUSTOMER(Arrays.asList(Permission.READ_ALL_PRODUCTS)),
    ADMIN(Arrays.asList(Permission.READ_ALL_PRODUCTS,Permission.SAVE_ONE_PRODUCT))

    private List<Permission> permissions;
}
