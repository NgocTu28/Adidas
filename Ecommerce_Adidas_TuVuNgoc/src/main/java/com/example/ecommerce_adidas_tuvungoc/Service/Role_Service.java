package com.example.ecommerce_adidas_tuvungoc.Service;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Role_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Role_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Role_Service {
    Role findByName(String name);

    Role_Reponse add(Role_Create roleCreate);

    Role_Reponse update(Role_Update roleUpdate);

    List<Role_Reponse> findByStatusList(Integer status);

    Page<Role_Reponse> getAll(int page, int size);

    Page<Role_Reponse> findByStatus(int page, int size, Integer status);

    Role_Reponse findById(Integer id);

    void delete(Integer id);

    boolean existByName(String name);

    boolean existByNameAndDifferentId(String name, Integer id);
}
