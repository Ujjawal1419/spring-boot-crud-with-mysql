package com.ibm.spring_boot_crud_with_mysql.user;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	
	@RequestMapping(value="/user",method = RequestMethod.GET)
	public String getUser() {
		return "This is User Controller";
	}
	
	@GetMapping(value = "/todaysDate")
	public String getTodatDate() {
		System.out.println("user class");
		return "today date and time= "+LocalDateTime.now();
	}
}
