package com.example.ecommerce_adidas_tuvungoc.Service.Implement;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Role_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Role;
import com.example.ecommerce_adidas_tuvungoc.Mapper.Role_Mapper;
import com.example.ecommerce_adidas_tuvungoc.Repository.Role_Repository;
import com.example.ecommerce_adidas_tuvungoc.Service.Role_Service;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Primary
@AllArgsConstructor
public class RoleService_Implement implements Role_Service {
    private final Role_Mapper roleMapper;
    private final Role_Repository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name.trim()).orElse(null);
    }

    @Override
    public Role_Reponse add(Role_Create roleCreate) {
        Role role = roleMapper.createToEntity(roleCreate);
        return roleMapper.entityToResponse(roleRepository.save(role));
    }

    @Override
    public Role_Reponse update(Role_Update roleUpdate) {
        Role role = roleRepository.findById(roleUpdate.getId()).orElse(null);
        if (role != null) {
            role = roleMapper.updateToEntity(roleUpdate, role);
            return roleMapper.entityToResponse(roleRepository.save(role));
        }
        return null;
    }

    @Override
    public List<Role_Reponse> findByStatusList(Integer status) {
        return roleMapper.listEntityToListResponse(roleRepository.findByStatusList(status));
    }

    @Override
    public Page<Role_Reponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return roleMapper.listEntityToListResponse(roleRepository.getAll(pageable));
    }

    @Override
    public Page<Role_Reponse> findByStatus(int page, int size, Integer status) {
        Pageable pageable = PageRequest.of(page, size);
        return roleMapper.listEntityToListResponse(roleRepository.findByStatus(pageable, status));
    }

    @Override
    public Role_Reponse findById(Integer id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null) return roleMapper.entityToResponse(role);
        return null;
    }


    @Override
    public void delete(Integer id) {
        Role role = roleRepository.findById(id).orElse(null);
        if (role != null) roleRepository.delete(role);
    }

    @Override
    public boolean existByName(String name) {
        return roleRepository.existsByName(name.trim());
    }

    @Override
    public boolean existByNameAndDifferentId(String name, Integer id) {
        if (roleRepository.existsByNameAndDifferentId(name.trim(), id).size() > 0) return true;
        return false;
    }
}
