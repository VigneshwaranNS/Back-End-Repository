package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.Employee;
import com.example.demo.service.LoginService;
import com.google.gson.Gson;

@RestController
@CrossOrigin("*")
@RequestMapping("API")
public class LoginController {
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	
	@Autowired
	LoginService login_service;
	
	@Autowired
	Gson gson;
	
	@GetMapping("/getEmployee")
	public ResponseEntity<String> getEmployee(@RequestBody Employee employee){
		
		String response_data= "";
		try {
			
			log.info("Action - getEmployeeRecordService, Input - "+gson.toJson(employee));

			List<Employee> response = login_service.getEmployeeRecordService(employee);
			
			response_data = "{\"success\":"+response_data+"}";
			
			log.info("Action - getEmployeeRecordService, Response - "+gson.toJson(response));

			return new ResponseEntity<String>(response_data,HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			log.info("Exception - getEmployeeRecordService, Error - "+gson.toJson(e.toString()));
			e.printStackTrace();
		}
		return null;
	}
}
