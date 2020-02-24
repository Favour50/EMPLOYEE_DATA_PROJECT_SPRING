package com.employee.service;

import com.employee.entity.Employee;

public interface EmployeeService {
	
	public void savedEmployee(Employee newEmployee);
	
	public Employee getById(int employeeId);
	
	public Employee getByEmail(String email);

}
