package com.crud.operation.springbootbackend.service;
import com.crud.operation.springbootbackend.entity.Employee;
import com.crud.operation.springbootbackend.exception.ResourceNotFoundException;
import com.crud.operation.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not exist with id:"+id)
        );
        return employee;
    }

    public Employee updateEmployee(long id, Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Employee not exist with id:"+id)
        );

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmail(employeeDetails.getEmail());

        employeeRepository.save(updateEmployee);

        return updateEmployee;
    }

    public void deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Employee not exist with id:"+id)
                );
        employeeRepository.delete(employee);
    }
}
