package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	public void savedEmployee(Employee newEmployee);
	
	public Employee getById(int employeeId);
	
	public Employee getByEmail(String email);

	public List<Employee> findAll();

	

}
