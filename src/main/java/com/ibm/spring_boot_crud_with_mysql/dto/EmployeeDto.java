package com.ibm.spring_boot_crud_with_mysql.dto;

public class EmployeeDto {
	
	private int id;
	private String name;
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
