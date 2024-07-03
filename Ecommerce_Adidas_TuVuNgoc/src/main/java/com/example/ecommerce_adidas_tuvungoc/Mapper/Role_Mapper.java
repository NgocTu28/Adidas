package com.example.ecommerce_adidas_tuvungoc.Mapper;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Role_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Role_Mapper {
    Role createToEntity(Role_Create create);

    Role updateToEntity(Role_Update update, Role role);

    Role_Reponse entityToResponse(Role role);

    Page<Role_Reponse> listEntityToListResponse(Page<Role> rolePage);

    List<Role_Reponse> listEntityToListResponse(List<Role> roleList);
}
