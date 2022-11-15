package com.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dto.*;
import com.exceptions.*;
import com.service.IfcAppointmentService;

@RestController
@CrossOrigin("*")
public class AppointmentController {
	
	@Autowired
	private IfcAppointmentService appointmentService;
	
	@PostMapping(path = "appointments/book")
	public Appointment bookAppointment(@RequestBody Appointment appointment) {
		appointmentService.bookAppointment(appointment);
		return appointment;
	}
	
	@PutMapping(path = "appointments/update")
	public Appointment updateAppointment(@RequestBody Appointment appointment)throws InvalidAppointmentException, AppointmentIdNotFoundException{
		appointmentService.updateAppointment(appointment);
		return appointment;
	}
	
	@DeleteMapping(path = "appointments/delete/{appointmentId}")
	public Appointment cancelAppointment(@PathVariable int appointmentId)throws AppointmentIdNotFoundException{
		return appointmentService.cancelAppointment(appointmentId);
	}
	
	@GetMapping(path = "appointments/view/{appointmentId}")
	public Appointment viewAppointment(@PathVariable int appointmentId)throws AppointmentIdNotFoundException{
		return appointmentService.viewAppointment(appointmentId);
	}
	
	@GetMapping(path = "appointments/viewAll")
	public List<Appointment> viewAllAppointments() throws AppointmentIdNotFoundException{
		return appointmentService.viewAllAppointments();
	}
	
	@GetMapping(path = "appointments/viewByDate/{date}")
	public List<Appointment> viewAppointmentsByDate(@PathVariable String date) throws AppointmentIdNotFoundException{
		LocalDate d1 = LocalDate.parse(date);
		return appointmentService.viewAppointmentsByDate(d1);
	}
	
	@GetMapping(path = "appointments/viewByPatientId/{patientId}")
	public List<Appointment> viewAppointmentByPatientId(@PathVariable int patientId)throws AppointmentIdNotFoundException {
		return appointmentService.viewAppointmentByPatientId(patientId);
	}
	
}