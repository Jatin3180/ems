package com.example.ems.controllers;

import static com.example.ems.constants.Constants.EMPLOYEE_BASE_URL;
import static com.example.ems.constants.Constants.ADD_EMPLOYEE;
import static com.example.ems.constants.Constants.UPDATE_EMPLOYEE;
import static com.example.ems.constants.Constants.GET_EMPLOYEE;
import static com.example.ems.constants.Constants.DELETE_EMPLOYEE;

import java.util.List;
import java.util.Optional;

import static com.example.ems.constants.Constants.LIST_EMPLOYEE;
import com.example.ems.model.employee;
import com.example.ems.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;



@Validated
@RestController
@RequestMapping(EMPLOYEE_BASE_URL)
public class EmployeeController {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeServices employeeservice;
	
	
	@PostMapping(value =  ADD_EMPLOYEE, consumes = MediaType.APPLICATION_JSON_VALUE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<employee> AddEmployee(@RequestBody employee employeeobject)throws Exception
	{
		final String methodName = "AddEmployee()";
		logger.info("{}: This service is adding a new employee" , methodName);	
		try {
			employee savedEmployee = employeeservice.addEmployee(employeeobject);
			return ResponseEntity.ok(savedEmployee);	 
		}catch(Exception e)
		{
			return new ResponseEntity<employee>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	
	  @PostMapping(value =  UPDATE_EMPLOYEE, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<employee> UpdateEmployee(@RequestBody employee employeeobject
					,@RequestParam int emp_id)throws Exception
			{
				final String methodName = "UpdateEmployee()";
				logger.info("{}: This service is updating a employee" , methodName);	
				try {
					employee savedEmployee = employeeservice.updateEmployee(employeeobject,emp_id);
					return ResponseEntity.ok(savedEmployee);	 
				}catch(Exception e)
				{
					return new ResponseEntity<employee>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			
		@SuppressWarnings("unchecked")
		@GetMapping(value = LIST_EMPLOYEE, produces = MediaType.APPLICATION_JSON_VALUE)			
		public @ResponseBody List<employee> getAllEmployee()throws Exception
		{
			final String methodName = "ListEmployee()";
			logger.info("{}: This service is list the employees" , methodName);	
			try {
				return employeeservice.getAllEmployees();
			}catch(Exception e)
			{
				return (List<employee>) new ResponseEntity<employee>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping(value = GET_EMPLOYEE, produces = MediaType.APPLICATION_JSON_VALUE)			
		public @ResponseBody employee getEmployee(
				@PathVariable int emp_id)throws Exception
		{
			final String methodName = "GetEmployee()";
			logger.info("{}: This service is get the employee" , methodName);	
		
				return employeeservice.getEmployee(emp_id);
			
		}
		
		@DeleteMapping(value = DELETE_EMPLOYEE, produces = MediaType.APPLICATION_JSON_VALUE)			
		public Void deleteEmployee(
				@PathVariable int emp_id)throws Exception
		{
			final String methodName = "DeleteEmployee()";
			logger.info("{}: This service is for delete the employee" , methodName);	
		
				return employeeservice.deleteEmployee(emp_id);
			
		}
		
		
	
	
	

}
