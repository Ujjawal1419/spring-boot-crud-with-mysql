package com.ibm.spring_boot_crud_with_mysql.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
