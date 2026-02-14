package com.ibm.spring_boot_crud_with_mysql.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	
	@RequestMapping(value="/user")
	public String getUser() {
		return "This is User Controller";
	}
}
