package com.ibm.spring_boot_crud_with_mysql.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_with_mysql.dto.EmployeeDto;

@RestController
public class EmployeeController {
	
	
	@GetMapping(value="/todaysdate")
	public String getTodaydate() {
		return "today date=" +LocalDate.now();
	}
	
	
	@PostMapping(value="/add{a}/{b}")
	public int add(@PathVariable(name="a") Integer a , @PathVariable(name="b") Integer b) {
		return a+b;
		
	}
	
	
	@PostMapping(value="/saveEmployeeDto")
	public EmployeeDto saveEmployeeDtoController(@RequestBody EmployeeDto employeeDto) {
		System.out.println(employeeDto);
		return employeeDto;
	}
	
	
	@PostMapping(value="/saveMultipleEmployeeDto")
	public List<EmployeeDto> saveMultipledtoController (@RequestBody List<EmployeeDto> employeeDto){
		System.out.println(employeeDto);
		return employeeDto;
	}
	
	@GetMapping(value="/getEmployeeById{id}")
	public EmployeeDto getEmployeeByIdController(Integer id) {
		return null;
	}

}
