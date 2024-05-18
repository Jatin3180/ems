package com.example.ems.services;

import com.example.ems.config.ResourceNotFoundException;

public class EmployeeNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = -4185306016942664972L;

	public EmployeeNotFoundException(int emp_id) {
		super("employee", "emp-id", emp_id);
	}
}
