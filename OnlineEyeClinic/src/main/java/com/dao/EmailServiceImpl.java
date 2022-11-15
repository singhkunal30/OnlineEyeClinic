package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.dto.EmailDetails;
import com.service.IfcEmailService;

@Service
public class EmailServiceImpl implements IfcEmailService {
	
	@Autowired 
    private JavaMailSender javaMailSender;
  
    @Value("${spring.mail.username}") private String sender;
 
    public EmailDetails sendSimpleMail(EmailDetails details){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(sender);
        mailMessage.setTo(details.getRecipient());
        mailMessage.setText(details.getMsgBody());
        mailMessage.setSubject(details.getSubject()); 
        javaMailSender.send(mailMessage);
        return details;
    }
}
