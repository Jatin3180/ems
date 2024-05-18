package com.example.ems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.example.ems.model.employee;
import com.example.ems.repository.EmployeeRepository;

@Component
@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EmployeeServices.class);

//	ADD EMPLOYEE
	public employee addEmployee(employee employeeobject) {
		 return employeeRepository.save(employeeobject);
	}

//	LIST OF EMPLOYEES
	public List<employee> getAllEmployees() {
        return (List<employee>) employeeRepository.findAll();
    }

//	UPDATE EMPLOYEE BY ID
	public employee updateEmployee(employee employeeobject, int emp_id) {
		  return employeeRepository.findById(emp_id).map(employee -> {
	            employee.setEmp_name(employeeobject.getEmp_name());
	            employee.setEmp_email(employeeobject.getEmp_email());
	            employee.setEmp_department(employeeobject.getEmp_department());
	            employee.setJoining_date(employeeobject.getJoining_date());
	            return employeeRepository.save(employee);
	        }).orElseThrow(() -> new RuntimeException("Employee not found with id: " + emp_id));
	    }

//  GET EMPLOYEE BY ID
	public employee getEmployee(int emp_id) {
		return employeeRepository.findById(emp_id).orElseThrow(() -> new EmployeeNotFoundException(emp_id));
	}


//  DELETE EMPLOYEE BY ID
	public Void deleteEmployee(int emp_id) {
		if (employeeRepository.existsById(emp_id)) {
			employeeRepository.deleteById(emp_id);
        } else {
            throw new RuntimeException("Employee not found with id: " + emp_id);
        }
		return null;
	}	
}
