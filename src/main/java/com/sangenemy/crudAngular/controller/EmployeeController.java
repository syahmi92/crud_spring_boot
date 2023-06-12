package com.sangenemy.crudAngular.controller;

import com.sangenemy.crudAngular.entity.EmployeeEntity;
import com.sangenemy.crudAngular.exception.ResourceNotFoundException;
import com.sangenemy.crudAngular.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Get all employees
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployee(){
        return employeeService.findAllEmployee();
    }

    //Create employee REST api
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employee){
        return employeeService.saveEmployee(employee);
    }

    //Get employee by id REST api
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        EmployeeEntity employee = employeeService.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id)); //Will return optional datatype and throw exception if id not match
        return ResponseEntity.ok(employee); //Return employee model/entity
    }

    //Update employee REST api
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/employees/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity employeeEntity){
        EmployeeEntity employee = employeeService.findById(id) //Retrieve database data of one employee
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id)); //Will return optional datatype and throw exception if id not match

        //Get new information updated from the user
        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmailId(employeeEntity.getEmailId());

        EmployeeEntity updatedEmployee = employeeService.saveEmployee(employee); //Create separate new object for update
        return ResponseEntity.ok(updatedEmployee);
    }

    //Delete employee REST api
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployeeById(@PathVariable Long id){
        EmployeeEntity employee_entity = employeeService.findById(id) //Retrieve database data of one employee
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id :" + id)); //Will return optional datatype and throw exception if id not match

        employeeService.deleteEmployee(employee_entity); //Delete the object
        Map<String, Boolean> responce = new HashMap<>();
        responce.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(responce);
    }

}
