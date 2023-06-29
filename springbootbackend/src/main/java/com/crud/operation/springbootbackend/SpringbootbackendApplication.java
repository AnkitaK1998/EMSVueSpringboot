package com.crud.operation.springbootbackend;

import com.crud.operation.springbootbackend.entity.Employee;
import com.crud.operation.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbackendApplication.class, args);
	}


}
