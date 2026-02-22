package com.ibm.spring_boot_crud_with_mysql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Employee Data Transfer object i  used this class to validate JSON data coming from client")
public class EmployeeDto {
	
	@Positive(message = "id should be positive")
	private int id;
	
	@NotEmpty(message = "Name should not be empty")
	@NotNull(message = "Name should not be null")
	private String name;
	@Email(message = "Email  is invalid  format")
	
	@Schema(description = "email should be valid format",example = "ujjawal@gmail.com")
	private String email;
	private String department;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + "]";
	}
	
	
	

}
