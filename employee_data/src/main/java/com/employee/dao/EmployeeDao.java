package com.employee.dao;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeDao {
	
	public void saveEmployee(Employee newEmployee);
	
	public Employee getById(int employeeId);
	 
	public Employee getByEmail(String email);
	
	public List<Employee> findAll();

}
