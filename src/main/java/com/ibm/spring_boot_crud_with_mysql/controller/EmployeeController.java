package com.ibm.spring_boot_crud_with_mysql.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.ibm.spring_boot_crud_with_mysql.user.UserController;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_with_mysql.dto.EmployeeDto;

@RestController
public class EmployeeController {

//    private final UserController userController;
//
//    EmployeeController(UserController userController) {
//        this.userController = userController;
//    }
	
	List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();
	
	@GetMapping(value="/todaysdate")
	public String getTodaydate() {
		return "today date=" +LocalDate.now();
	}
	
	
	@PostMapping(value="/add{a}/{b}")
	public int add(@PathVariable(name="a") Integer a , @PathVariable(name="b") Integer b) {
		return a+b;
		
	}
	
	
	@PostMapping(value="/saveEmployeeDto")
	public EmployeeDto saveEmployeeDtoController(@RequestBody @Valid EmployeeDto employeeDto) {
		System.out.println(employeeDto);
		return employeeDto;
	}
	
	
	@PostMapping(value="/saveMultipleEmployeeDto")
	public List<EmployeeDto> saveMultipledtoController (@RequestBody List<EmployeeDto> employeeDto){
		System.out.println(employeeDto);
		return employeeDto;
	}
	
	@GetMapping(value="/getEmployeeById/{id}")
	public  ResponseEntity<?>  getEmployeeByIdController(@PathVariable(name = "id")   Integer id) {
		
		if(employeeDtos.isEmpty()) {
			System.out.println("employeeDtos list is empty");
			return ResponseEntity.ok("employeeDtos list is not found");
		}
		
		for(EmployeeDto employeeDto : employeeDtos) {
			if(id==employeeDto.getId()) {
				return ResponseEntity.ok(employeeDto) ;
			}
		}
		System.out.println("The given id is not found");
		return  ResponseEntity.ok("The given id is not found");
	}

}
