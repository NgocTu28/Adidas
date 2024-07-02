package com.example.ecommerce_adidas_tuvungoc.Service.Implement;

import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Create;
import com.example.ecommerce_adidas_tuvungoc.Dto.Request.Employee_Update;
import com.example.ecommerce_adidas_tuvungoc.Dto.Response.Employee_Reponse;
import com.example.ecommerce_adidas_tuvungoc.Entity.Employee;
import com.example.ecommerce_adidas_tuvungoc.Entity.Role;
import com.example.ecommerce_adidas_tuvungoc.Mapper.Employees_Mapper;
import com.example.ecommerce_adidas_tuvungoc.Repository.Employee_Repository;
import com.example.ecommerce_adidas_tuvungoc.Repository.Role_Repository;
import com.example.ecommerce_adidas_tuvungoc.Service.Employee_Service;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Component
@AllArgsConstructor
@Primary
public class EmployeeService_Implement implements Employee_Service {
    private final Employee_Repository employee_Repository;
    private final Role_Repository role_Repository;
    private final Employees_Mapper employeesMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Employee_Reponse add(Employee_Create employeeCreate) {
        Optional<Role> role = role_Repository.findById(employeeCreate.getIdRole());
        if (role.isPresent()) {
            Employee employee = employeesMapper.createEmployeeToEmployee(employeeCreate);
            employee.setPassword(passwordEncoder.encode(employee.getPassword()));
            employee.setRole(role.get());
            return employeesMapper.employeeEntityToEmployeeReponse(employee_Repository.save(employee));
        }
        return null;
    }

    @Override
    public Employee_Reponse update(Employee_Update employeeUpdate) {
        Optional<Role> role = role_Repository.findById(employeeUpdate.getIdRole());
        Optional<Employee> employee = employee_Repository.findById(employeeUpdate.getId());
        if (role.isPresent() && employee.isPresent()) {
            Employee toEntity = employeesMapper.updateEmployeeToEmployee(employeeUpdate, employee.get());
            return employeesMapper.employeeEntityToEmployeeReponse(employee_Repository.save(toEntity));
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Optional<Employee> staff = employee_Repository.findById(id);
        if (staff.isPresent())
            employee_Repository.delete(staff.get());
    }

    @Override
    public Page<Employee_Reponse> getAll(Pageable pageable) {
        return employeesMapper.listEmployeeEntityToEmployeeReponsePage(employee_Repository.getAll(pageable));
    }

    @Override
    public Page<Employee_Reponse> findByStatus(Pageable pageable, Integer status) {
        return employeesMapper.listEmployeeEntityToEmployeeReponsePage(employee_Repository.findByStatus(pageable, status));
    }

    @Override
    public boolean isExistByUsername(String username) {
        return employee_Repository.existsByUsername(username);
    }

    @Override
    public Employee_Reponse findById(Integer id) {
        return employeesMapper.employeeEntityToEmployeeReponse(employee_Repository.findById(id).orElse(null));
    }

    @Override
    public boolean existByEmail(String email) {
        if (employee_Repository.existsByEmail(email)) {
            System.out.println(employee_Repository.existsByEmail(email));
            return true;
        }
        return false;
    }
}
