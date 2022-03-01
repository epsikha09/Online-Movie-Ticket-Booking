package com.mts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mts.service.IAdminService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	IAdminService adminService;

	
	@PostMapping("/registeradmin/{username}/{password}")
	public HttpStatus registerAdmin(@PathVariable String username, @PathVariable String password) throws Exception {
		logger.info("-------------------Admin created-----------------");
		adminService.registerAdmin(username, password);
		return HttpStatus.CREATED;
	}
}