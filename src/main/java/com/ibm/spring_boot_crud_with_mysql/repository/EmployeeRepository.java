package com.ibm.spring_boot_crud_with_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.spring_boot_crud_with_mysql.entity.Employee;
import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//select * from employee where name=name;
	List<Employee> findByName(String name);
	
	Optional<Employee>  findByEmail(String email);
	
	Optional<Employee> findByDepartment(String department);
        
	  @Query(value = "Delete from Employee e where e.name=?1")
	   void deleteEmployeeByName(String name );
}
