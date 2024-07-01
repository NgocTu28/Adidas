package com.example.ecommerce_adidas_tuvungoc.Repository;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Customer_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Customer_Repository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.email = :email")
    Optional<Customer> findByEmail(@Param("email") String email);

    @Query("SELECT s FROM Customer s")
    Page<Customer> getAll(Pageable pageable);

    @Query("SELECT s FROM Customer s WHERE s.status = :status")
    Page<Customer> findByStatus(Pageable pageable, @Param("status") Integer status);

    @Query("SELECT s FROM Customer s WHERE s.id = :id")
    Optional<Customer> findById(@Param("id") Long id);

    @Query("SELECT s FROM Customer s WHERE s.role.id = :roleId")
    List<Customer> findByRoleId(@Param("roleId") Long roleId);

    boolean existsByEmail(String email);

    boolean existsByCode(String code);

    boolean existsByPhone(String phone);
    Customer createCustomerWithSessionId(String sessionId);

    Customer findBySessionId(String sessionId);

    Customer updateForCustomerGuest(Customer_Update update);

    Customer findByIdEntity(Long id);

    Page<Customer_Reponse> findByNameOrPhoneOrEmailOrCode(String key, Pageable pageable);
}
