package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.repository.LoginRepository;
import com.google.gson.Gson;

@Service
public class LoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginService.class);
	
	@Autowired
	LoginRepository login_repo;
	
	@Autowired
	Gson gson;
	
	
	public List<Employee> getEmployeeRecordService(Employee emp){
		
		log.info("Action - getEmployeeRecordService, Input - "+gson.toJson(emp));
		
		List<Employee> response = login_repo.getEmployeeRecord(emp);
		
		log.info("Action - getEmployeeRecordService, Response - "+gson.toJson(response));
	
		return response;
	}
}
