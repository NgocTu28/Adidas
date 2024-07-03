package com.example.ecommerce_adidas_tuvungoc.Mapper.Implement;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Role_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Role;
import com.example.ecommerce_adidas_tuvungoc.Mapper.Role_Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoleMapper_Implement implements Role_Mapper {
    @Override
    public Role createToEntity(Role_Create create) {
        Role role = Role.builder()
                .name(create.getName().trim())
                .status(create.getStatus())
                .build();
        return role;
    }

    @Override
    public Role updateToEntity(Role_Update update, Role role) {
        role.setName(update.getName().trim());
        role.setStatus(update.getStatus());
        return role;
    }

    @Override
    public Role_Reponse entityToResponse(Role role) {
        Role_Reponse response = Role_Reponse.builder()
                .id(role.getId())
                .name(role.getName())
                .status(role.getStatus())
                .createAt(String.valueOf(role.getCreateAt()))
                .createBy(role.getCreateBy())
                .modifyAt(String.valueOf(role.getModifyAt()))
                .modifyBy(role.getModifyBy())
                .build();
        response.convertTime();
        return response;
    }

    @Override
    public Page<Role_Reponse> listEntityToListResponse(Page<Role> rolePage) {
        List<Role_Reponse> responses = rolePage.getContent()
                .stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(responses, rolePage.getPageable(), rolePage.getTotalElements());
    }

    @Override
    public List<Role_Reponse> listEntityToListResponse(List<Role> roleList) {
        return roleList.stream().map(this::entityToResponse).collect(Collectors.toList());
    }
}
