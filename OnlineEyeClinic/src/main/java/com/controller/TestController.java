package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.ITestService;

@RestController
public class TestController {
	
	@Autowired
	private ITestService testService;
}
