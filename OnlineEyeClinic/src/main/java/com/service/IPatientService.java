package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Appointment;
import com.dto.Patient;
import com.dto.Report;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.PatientIdFoundNotException;

@Service
public interface IPatientService {
	Patient addPatient(Patient patient);
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId)throws PatientIdFoundNotException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId)throws PatientIdFoundNotException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetails(int appointmentid)throws AppointmentIdNotFoundException;
	Report viewReport(int patientId)throws PatientIdFoundNotException;
}
