package com.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.dto.Patient;
import com.exceptions.PatientIdNotFoundException;
@Service
public interface IfcPatientService {
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient) throws PatientIdNotFoundException;
	Patient deletePatient(int patientId)throws PatientIdNotFoundException;
	List<Patient> viewPatientList() throws PatientIdNotFoundException;
	Patient viewPatient(int patientId)throws PatientIdNotFoundException;
}
