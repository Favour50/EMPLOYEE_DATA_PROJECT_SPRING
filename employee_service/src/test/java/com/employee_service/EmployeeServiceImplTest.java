/**
 * 
 */
package com.employee_service;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.employee.dao.EmployeeDao;
import com.employee.entity.Employee;

/**
 * @author user
 *
 */

@ContextConfiguration("classpath:service-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {
	
	
	@Mock
	private EmployeeDao employeeDaoImpl;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		employeeDaoImpl = mock(EmployeeDao.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void saveEmployeeTest() {
		
		//create an object
		Employee tempEmployee = new Employee();
		
		
		//define mock method call
		doNothing().when(employeeDaoImpl).saveEmployee(isA(Employee.class));
		
		//make a a mock call
		employeeDaoImpl.saveEmployee(tempEmployee);
		
		//verify the method was called
		verify(employeeDaoImpl, times(1)).saveEmployee(tempEmployee);
		
	}
	
	@Test
	public void getEmployeeByIdTest() {
		
		Employee tempEmployee = new Employee();
		
		when(employeeDaoImpl.getById(1)).thenReturn(tempEmployee);
		
		employeeDaoImpl.getById(1);
		
		verify(employeeDaoImpl, times(1)).getById(1);
	}
	
	@Test
	public void getEmployeeByEmailTest() {
	
	Employee tempEmployee = new Employee();
	
	when(employeeDaoImpl.getByEmail("test@mail.com")).thenReturn(tempEmployee);
	
	employeeDaoImpl.getByEmail("test@mail.com");
	
	verify(employeeDaoImpl, times(1)).getByEmail("test@mail.com");
	
	}
	
	@Test
	public void findAllEmployeesTest() {
		List<Employee> employees = null;
		
		when(employeeDaoImpl.findAll()).thenReturn(employees);
		
		
		employeeDaoImpl.findAll();
		verify(employeeDaoImpl, times(1)).findAll();
	}

}
