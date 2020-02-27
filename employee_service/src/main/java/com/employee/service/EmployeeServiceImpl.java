package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDaoImpl;

	public void savedEmployee(Employee newEmployee) {
		employeeDaoImpl.saveEmployee(newEmployee);

	}

	public Employee getById(int employeeId) {
		
		Employee savedEmployee = employeeDaoImpl.getById(employeeId);
		return savedEmployee;
	}

	public Employee getByEmail(String email) {
		
		Employee savedEmployee = employeeDaoImpl.getByEmail(email);
		return savedEmployee;
	
	}
	
	public List<Employee> findAll(){
		
		List<Employee> result = employeeDaoImpl.findAll();
		
		return result;
	}

}
