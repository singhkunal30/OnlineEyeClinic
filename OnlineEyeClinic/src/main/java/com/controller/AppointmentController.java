package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.IAppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	private IAppointmentService aptService;
	
}
