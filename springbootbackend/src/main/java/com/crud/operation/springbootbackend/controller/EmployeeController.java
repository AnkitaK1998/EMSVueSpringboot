package com.crud.operation.springbootbackend.controller;

import com.crud.operation.springbootbackend.entity.Employee;
import com.crud.operation.springbootbackend.exception.ResourceNotFoundException;
import com.crud.operation.springbootbackend.repository.EmployeeRepository;
import com.crud.operation.springbootbackend.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin("http://localhost:8081/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeServiceImpl;

    @GetMapping
    public List<Employee>  getAllEmployees(){
        return employeeServiceImpl.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeServiceImpl.createEmployee(employee);
    }
    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable long id){
        return employeeServiceImpl.getEmployeeById(id);


    }
    @PutMapping("{id}")
    public Employee updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
       return employeeServiceImpl.updateEmployee(id,employeeDetails);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        employeeServiceImpl.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}