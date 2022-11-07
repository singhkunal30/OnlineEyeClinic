package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.IDoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private IDoctorService docService;
	
}
