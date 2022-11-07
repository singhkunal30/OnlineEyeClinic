package com.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.dto.Appointment;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.InvalidAppointmentException;

@Service
public interface IAppointmentService{
	Appointment bookAppointment(Appointment appointment);
	Appointment updateAppointment(Appointment appointment)throws InvalidAppointmentException;
	Appointment cancelAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	Appointment viewAppointment(int appointmentId)throws AppointmentIdNotFoundException;
	List<Appointment> viewAllAppointments();
	List<Appointment> viewAppointments(LocalDate date);
}
