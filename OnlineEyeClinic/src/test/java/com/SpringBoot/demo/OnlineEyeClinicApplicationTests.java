package com.SpringBoot.demo;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.dto.Appointment;
import com.exceptions.AppointmentIdNotFoundException;
import com.repository.IfcAppointmentRepository;
import com.service.IfcAppointmentService;

@SpringBootTest
class OnlineEyeClinicApplicationTests {
	
//	@Autowired
//	private IfcAppointmentService aptService;
//	@MockBean
//	private IfcAppointmentRepository aptRepository;
//	
//	@Test
//	public void addAppointmentTest() {
//	}
//	
//	@Test
//	public void viewAllAppointmentsTest() throws AppointmentIdNotFoundException {
//		aptService.viewAllAppointments();
//		verify(aptRepository).findAll();
//	}

}
