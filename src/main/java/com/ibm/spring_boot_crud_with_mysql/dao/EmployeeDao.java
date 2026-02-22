package com.ibm.spring_boot_crud_with_mysql.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibm.spring_boot_crud_with_mysql.entity.Employee;
import com.ibm.spring_boot_crud_with_mysql.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployeeDao(Employee employee) {
		
		return employeeRepository.saveAndFlush(employee);
	}
	
	public Employee getEmployeeByIdDao(int id) {
		
		 Optional<Employee> optional=employeeRepository.findById(id);
		 
		 if(optional.isPresent()) {
			 return optional.get();
		 }else {
			 return null;
		 }
	}
	
	
	public List saveAllEmployeeDao(List<Employee> employee ){
		
		return employeeRepository.saveAllAndFlush(employee);
	}
	
	public List<Employee> getEmployeeByNameDao(String name){
		
		return employeeRepository.findByName(name);
	}
	
	public boolean deleteEmployeeByIdDao(int id) {
		
		Optional<Employee> optional= employeeRepository.findById(id);
		
		if(optional.isPresent()) {
			Employee employee= optional.get();
			employeeRepository.delete(employee);
			return true;
		}else {
			return false;
		}
	}
	
	public  boolean deleteEmployeeByNameDao(String name) {
		
		List<Employee> employees=employeeRepository.findByName(name);
		
		if(employees==null || employees.size()==0) {
			return false;
		}
		
		employeeRepository.deleteEmployeeByName(name);
		return true;
	}
	
}
