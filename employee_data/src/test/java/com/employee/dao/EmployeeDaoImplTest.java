package com.employee.dao;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.entity.Employee;


@Sql(scripts= {"classpath:/db/create-table.sql","classpath:/db/insert-employees.sql"})
@ContextConfiguration("classpath:data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {
	
	@Autowired
	private Environment env;
	
	@Autowired
	EmployeeDao  employeeDaoImpl;
	
	@Before
	public void setUp() throws Exception {
	
	}
	
	@After
	public void tearDown() throws Exception {
	}

	
	
	@Test
	public void saveEmployeeToDBTest() {
		assertThat(employeeDaoImpl).isNotNull();

		Employee newEmployee  = new Employee();
		newEmployee.setFirstName("Mary");
		newEmployee.setLastName("Black");
		newEmployee.setEmail("mary@mail.com");
		newEmployee.setPhoneNumber("070585746755");
		
		Date employeeDate = Date.valueOf("2000-07-24");
		newEmployee.setDateOfBirth(employeeDate);
		
		employeeDaoImpl.saveEmployee(newEmployee);
		
		int id = newEmployee.getEmployeeId();
		System.out.println("New Employee Id --> " + id);
		
		Employee existingEmployee = employeeDaoImpl.getById(id);
		assertThat(existingEmployee).isNotNull();
	
	}
      @Test
      public void getEmployeeByEmailTest() {
    	  
    	  assertThat(employeeDaoImpl).isNotNull();
    	  
    	  Employee savedEmployee = employeeDaoImpl.getByEmail("chris@mail.com");
    	  assertThat(savedEmployee).isNotNull();
    	  
    	  assertThat(savedEmployee.getEmployeeId()).isEqualTo(3);
    	  
    	  System.out.println(savedEmployee);
      }
      
      @Test
      public void getAllEmployeeByEmailTest() {
    	  
    	  assertThat(employeeDaoImpl).isNotNull();
    	  
    	  List<Employee> allEmployees = employeeDaoImpl.findAll();
    	  
    	  assertThat(allEmployees).isNotNull();
    	  
    	  assertThat(allEmployees).hasSize(5);
    	  
    	  allEmployees.forEach(System.out::println);
      } 	  
}
