package com.ibm.spring_boot_crud_with_mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(title = "Employee API",
   description = "This API is used to performe CRUD operations on employee data", 
   version = "1.0.0",
   contact = @Contact(
		   name = "Ujjawal Kumar",
		   email = "ujjawal1422@gmail.com",
		   url = "https://www.linkedin.com/in/ujjawal-kumar-609874261/overlay/contact-info/"
		   )))

public class SpringBootCrudWithMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudWithMysqlApplication.class, args);
		
	}

}
