package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Appointment;
import com.dto.Patient;
import com.dto.Report;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.PatientIdFoundNotException;
import com.repository.IAppointmentRepository;
import com.repository.IPatientRepository;
import com.repository.IReportRepository;
import com.service.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService{
	
	@Autowired
	private IPatientRepository patientRepository;
	
	@Autowired
	private IAppointmentRepository appointmentRepository;
	
	@Autowired
	private IReportRepository reportRepository;
	
	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		Patient p = patientRepository.findById(patient.getPatientId()).get();
		p.setAddress(patient.getAddress());
		p.setPatientAge(patient.getPatientAge());
		p.getPatReportList().clear();
		p.getPatReportList().addAll(patient.getPatReportList());
		p.getPatReportList().clear();
		p.getPatAptList().addAll(patient.getPatAptList());
		p.setPatientDOB(patient.getPatientDOB());
		p.setPatientEmail(patient.getPatientEmail());
		p.setPatientMobile(patient.getPatientMobile());
		p.setPatientName(patient.getPatientName());
		p.setPatientPassword(patient.getPatientPassword());
		p.setPatientUserName(patient.getPatientUserName());
		patientRepository.save(p);
		return p;
	}

	@Override
	public Patient deletePatient(int patientId) throws PatientIdFoundNotException {
		Patient p = patientRepository.findById(patientId).get();
		patientRepository.deleteById(patientId);
		return p;
	}

	@Override
	public List<Patient> viewPatientList() {
		return patientRepository.findAll();
	}

	@Override
	public Patient viewPatient(int patientId) throws PatientIdFoundNotException {
		Patient p = patientRepository.findById(patientId).get();
		return p;
	}

	@Override
	public Appointment bookAppointment(Appointment appointment) {
		Appointment apt = appointmentRepository.save(appointment);
		return apt;
	}

	@Override
	public Appointment viewAppointmentDetails(int appointmentid) throws AppointmentIdNotFoundException {
		Appointment apt = appointmentRepository.findById(appointmentid).get();
		return apt;
	}

	@Override
	public Report viewReport(int patientId) throws PatientIdFoundNotException {
		Report rpt = reportRepository.findById(patientId).get();
		return rpt;
	}

}
