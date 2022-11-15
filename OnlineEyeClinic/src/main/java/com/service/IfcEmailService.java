package com.service;


import com.dto.EmailDetails;

public interface IfcEmailService {
	EmailDetails sendSimpleMail(EmailDetails details);
}