package com.sangenemy.crudAngular.repository;

import com.sangenemy.crudAngular.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    //Not need to create method as JpaRepository have all available method
    // --> Click on JpaRepository (after the extends word above) to view all built in method
    //If custom method needed, we can include it here.

}
