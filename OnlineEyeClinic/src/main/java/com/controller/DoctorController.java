package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dto.*;
import com.service.*;
import com.exceptions.*;

@RestController
@CrossOrigin("*")
public class DoctorController {
	
	@Autowired
	private IfcDoctorService doctorService;
	
	@PostMapping(path="doctor/add")
	public Doctor addDoctor (@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}
	
	@PutMapping(path="doctor/update")
	public Doctor updateDoctor(@RequestBody Doctor doctor) throws DoctorIdNotFoundException{
		return doctorService.updateDoctor(doctor);
	}
	
	@DeleteMapping(path="doctor/deleteById/{doctorId}")
	public Doctor deleteDoctor(@PathVariable int doctorId) throws DoctorIdNotFoundException {
		return doctorService.deleteDoctor(doctorId);
	}
	
	@GetMapping(path="doctor/viewById/{doctorId}")
	public Doctor viewDoctor(@PathVariable int doctorId) throws DoctorIdNotFoundException {
		return doctorService.viewDoctor(doctorId);
	}
	
	@GetMapping(path="doctor/viewAll")
	public List<Doctor> viewDoctorsList() throws DoctorIdNotFoundException {
		return doctorService.viewDoctorsList();
	}
	
	@GetMapping(path="doctor/viewAppointments/{doctorId}")
	public List<Appointment> viewAppointments(@PathVariable int doctorId) throws AppointmentIdNotFoundException{
		return doctorService.viewAppointments(doctorId);
	}
}