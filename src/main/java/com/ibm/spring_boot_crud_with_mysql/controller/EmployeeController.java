package com.ibm.spring_boot_crud_with_mysql.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.spring_boot_crud_with_mysql.dao.EmployeeDao;
import com.ibm.spring_boot_crud_with_mysql.dto.EmployeeDto;
import com.ibm.spring_boot_crud_with_mysql.entity.Employee;
import com.ibm.spring_boot_crud_with_mysql.exception.EmployeeNotFoundException;
import com.ibm.spring_boot_crud_with_mysql.exception.MyApplicationExceptionHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RequestMapping(value = "/employee")
@RestController
@Tag(name = "Employee Controller", description = "This is Controller is responsble for handle employee related operations")
public class EmployeeController {

	private final MyApplicationExceptionHandler myApplicationExceptionHandler;

//    private final UserController userController;
//
//    EmployeeController(UserController userController) {
//        this.userController = userController;
//    }

//	List<EmployeeDto> employeeDtos = new ArrayList<EmployeeDto>();

	@Autowired
	private EmployeeDao employeeDao;

	EmployeeController(MyApplicationExceptionHandler myApplicationExceptionHandler) {
		this.myApplicationExceptionHandler = myApplicationExceptionHandler;
	}

	@GetMapping(value = "/todaysDate")
	public String getTodaydate() {
		System.out.println("employee class");
		return "today date and time =" + LocalDateTime.now();
	}

	@PostMapping(value = "/add{a}/{b}")
	public int add(@PathVariable(name = "a") Integer a, @PathVariable(name = "b") Integer b) {
		return a + b;

	}

//	@PostMapping(value="/saveEmployeeDto")
//	public EmployeeDto saveEmployeeDtoController(@RequestBody @Valid EmployeeDto employeeDto) {
//		System.out.println(employeeDto);
//		return employeeDto;
//	}

	@Operation(summary = "save employee data in database", description = "This API is used to save employee data in database but before saving data it will Validate the JSON data calling using EmployeeDto class")
	@PostMapping(value = "/saveEmployeeDto")
	public ResponseEntity<?> saveEmployeeDtoController(@RequestBody @Valid EmployeeDto employeeDto) {

		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setDepartment(employeeDto.getDepartment());

		Employee employee2 = employeeDao.saveEmployeeDao(employee);

		HashMap<String, Object> response = new HashMap<String, Object>();

		if (employee2 != null) {
			response.put("message", "employee saved successfully");
			response.put("employee", employee2);
			return ResponseEntity.ok(response);

		} else {
			response.put("message", "employee data not saved");
			return ResponseEntity.ok(response);

		}
	}

	@PostMapping(value = "/saveMultipleEmployeeDto")
	public ResponseEntity<?> saveMultipledtoController(@RequestBody @Valid List<EmployeeDto> employeeDto) {

//		List<Employee> employeelist= new ArrayList<Employee>();

//		for(EmployeeDto employeeDto2 : employeeDto) {
//			Employee employee = new Employee();
//			employee.setId(employeeDto2.getId());
//			employee.setName(employeeDto2.getName());
//			employee.setEmail(employeeDto2.getEmail());
//			employee.setDepartment(employeeDto2.getDepartment());
//			
//			employeelist.add(employee);
//		}

		List<Employee> employees = employeeDto.stream()
				.map(dto -> new Employee(dto.getId(), dto.getName(), dto.getEmail(), dto.getDepartment())).toList();

		employeeDao.saveAllEmployeeDao(employees);

		return ResponseEntity.ok("Employees saved Successfully");

	}

//	@GetMapping(value="/getEmployeeById/{id}")
//	public  ResponseEntity<?>  getEmployeeByIdController(@PathVariable(name = "id")   Integer id) {
//		
//		if(employeeDtos.isEmpty()) {
//			System.out.println("employeeDtos list is empty");
//			return ResponseEntity.ok("employeeDtos list is not found");
//		}
//		
//		for(EmployeeDto employeeDto : employeeDtos) {
//			if(id==employeeDto.getId()) {
//				return ResponseEntity.ok(employeeDto) ;
//			}
//		}
//		System.out.println("The given id is not found");
//		return  ResponseEntity.ok("The given id is not found");
//	}

	@GetMapping(value = "/getEmployeeById/{id}")
	public ResponseEntity<?> getEmployeeByIdController(@PathVariable(name = "id") Integer id) {

		Employee employee = employeeDao.getEmployeeByIdDao(id);

		if (employee != null) {

			return ResponseEntity.ok(employee);

		} else {

			throw new EmployeeNotFoundException("employee not found with id= " + id);
		}

	}

	@GetMapping(value = "/getEmployeeByName/{name}")
	public ResponseEntity<?> getEmployeeByNameDao(@PathVariable(name = "name") String name) {

		List<Employee> employees = employeeDao.getEmployeeByNameDao(name);

		if (employees != null && employees.size() > 0) {
			return ResponseEntity.ok(employees);
		} else {
			throw new EmployeeNotFoundException("employee not found with name= " + name);
		}
	}

	@DeleteMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<?> deleteEmployeeByIdDao(@PathVariable("id") int id) {

		boolean isDeleted = employeeDao.deleteEmployeeByIdDao(id);

		if (isDeleted) {
			return ResponseEntity.ok("employee deleted successfully with id= " + id);
		} else {
			throw new EmployeeNotFoundException("employee not found with id= " + id);
		}
	}
	
	@DeleteMapping(value = "deleteEmployeeByName {name}")
	public ResponseEntity<?> deleteEmployeeByNameDao(@PathVariable(name = "name")  String name) {
		
		boolean isDeleted = employeeDao.deleteEmployeeByNameDao(name);
		
		if(isDeleted) {
			
			return ResponseEntity.ok("employee deleted successfully with name= "+name);
		}else {
			
			throw new EmployeeNotFoundException("employee not found with name= "+name);
		}
	}

}
