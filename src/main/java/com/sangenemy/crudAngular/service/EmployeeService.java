package com.sangenemy.crudAngular.service;

import com.sangenemy.crudAngular.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeEntity> findAllEmployee();

    Optional<EmployeeEntity> findById(Long id);

    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployeeById(Long id);
    void deleteEmployee(EmployeeEntity employeeEntity);


}
