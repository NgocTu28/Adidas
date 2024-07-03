package com.example.ecommerce_adidas_tuvungoc.Repository;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Customer_Update;
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
    Optional<Customer> findById(@Param("id") Integer id);

    @Query("SELECT s FROM Customer s WHERE s.role.id = :roleId")
    List<Customer> findByRoleId(@Param("roleId") Integer roleId);

    @Query("SELECT c FROM Customer c WHERE c.email = :email AND c.phone = :phoneNumber")
    Customer findByPhoneNumberAndEmail(@Param("email") String email, @Param("phoneNumber") String phoneNumber);

    boolean existsByEmail(String email);

    boolean existsByCode(String code);

    boolean existsByPhone(String phone);

    Customer findBySessionId(String sessionId);
}
