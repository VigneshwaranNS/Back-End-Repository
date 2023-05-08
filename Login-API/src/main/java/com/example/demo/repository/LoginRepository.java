package com.example.demo.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.Employee;
import com.google.gson.Gson;

@Repository
public class LoginRepository {
	
	private static final Logger log = LoggerFactory.getLogger(LoginRepository.class);

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	Gson gson = new Gson();
	
	public List<Employee> getEmployeeRecord(Employee emp){
		
		log.info("Action - getEmployeeRecord , Input "+gson.toJson(emp));
		
		BeanPropertyRowMapper<Employee> rowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		/*
		 * Connection con; try { con = jdbcTemplate.getDataSource().getConnection(); }
		 * catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		String employee_sql = "select * from employee";
		
		List<Employee> response = jdbcTemplate.query(employee_sql,rowMapper);
		
		log.info("Action - getEmployeeRecord , Response"+gson.toJson(response));
		
		return response;
	}
}
