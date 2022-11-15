package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmailDetails;
import com.service.IfcEmailService;


@RestController
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private IfcEmailService emailService;
	
	@PostMapping(path = "forgotPassword")
	public EmailDetails sendMail(@RequestBody EmailDetails details){
		return emailService.sendSimpleMail(details);
	}
	
}
