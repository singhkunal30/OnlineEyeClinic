package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.IPatientService;

@RestController
public class PatientController {
	
	@Autowired
	private IPatientService patService;
	
}
