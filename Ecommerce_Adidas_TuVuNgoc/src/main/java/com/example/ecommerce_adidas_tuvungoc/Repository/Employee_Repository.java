package com.example.ecommerce_adidas_tuvungoc.Repository;

import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Employee_Repository extends JpaRepository<Employee, Integer> {
    @Query("SELECT s FROM Employee s")
    Page<Employee> getAll(Pageable pageable);

    @Query("SELECT s FROM Employee s WHERE s.status = :status")
    Page<Employee> findByStatus(Pageable pageable, @Param("status") Integer status);

    @Query("SELECT s FROM Employee s WHERE s.id = :id")
    Optional<Employee> findById(@Param("id") Long id);

    @Query("SELECT s FROM Employee  s WHERE s.email = :email")
    Optional<Employee> findByUsername(@Param("email") String email);

    @Query("SELECT s FROM Employee s WHERE s.name = :name")
    List<Employee> findByName(@Param("name") String name);

    @Query("SELECT s FROM Employee s WHERE s.role.id = :roleId")
    List<Employee> findByRoleId(@Param("roleId") Long roleId);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    @Query("SELECT s FROM Employee s WHERE s.email = :email AND s.id <> :id")
    List<Employee> existByEmailAndDifferentId(@Param("email") String email,@Param("id") Long id);
}


