package com.employee.config;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(name="testDataSource")
	public ComboPooledDataSource testDataSource() throws PropertyVetoException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setJdbcUrl(env.getProperty("test.jdbcUrl"));
		dataSource.setUser(env.getProperty("test.user"));
		dataSource.setPassword(env.getProperty("test.password"));
		dataSource.setDriverClass(env.getProperty("test.driver"));
		
		
	  return dataSource;
	}
	
}
