package com.example.ems.config;

public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5962898215276911029L;

	public ResourceNotFoundException(String resourceType, String keyName, int emp_id) {
		super(resourceType + " with " + keyName + "[" + emp_id + "] not found in the system!");
	}

}
