package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.dto.Patient;
import com.exceptions.PatientIdNotFoundException;
import com.service.IfcPatientService;

@RestController
@CrossOrigin("*")
public class PatientController {
	
	@Autowired
	private IfcPatientService patientService;
	
	@PostMapping(path="patient/add")
	public Patient addPatient (@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	@PutMapping(path="patient/update")
	public Patient updatePatient(@RequestBody Patient patient) throws PatientIdNotFoundException{
		return patientService.updatePatient(patient);
	}
	
	@DeleteMapping(path="patient/delete/{patientId}")
	public Patient deletePatient(@PathVariable int patientId)throws PatientIdNotFoundException{
		return patientService.deletePatient(patientId);
	}
	
	@GetMapping(path="patient/viewAll")
	public List<Patient> viewPatientList() throws PatientIdNotFoundException{
		return patientService.viewPatientList();
	}
	
	@GetMapping(path="patient/viewById/{patientId}")
	public Patient viewPatient(@PathVariable int patientId)throws PatientIdNotFoundException{
		return patientService.viewPatient(patientId);
	}
}
