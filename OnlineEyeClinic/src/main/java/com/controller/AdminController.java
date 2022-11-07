package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.service.IDoctorService;
import com.service.ITestService;

@RestController
public class AdminController {
	
	@Autowired
	public IDoctorService docService;
	
	@Autowired
	public ITestService testService;
}
