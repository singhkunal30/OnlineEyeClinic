package com.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Patient;
import com.exceptions.PatientIdNotFoundException;
import com.repository.IfcPatientRepository;
import com.service.IfcPatientService;
import org.springframework.stereotype.Service;
@Service
public class PatientServiceImpl implements IfcPatientService{
	
	@Autowired
	private IfcPatientRepository patientRepository;
	
	Logger log = LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Override
	public Patient addPatient(Patient patient) {
		log.info("Patient added");
		return patientRepository.save(patient);
	}

	@Override
	public Patient updatePatient(Patient patient) throws PatientIdNotFoundException {
		if(patientRepository.existsById(patient.getPatientId())) {
			log.info("Patient updated");
			Patient p = patientRepository.findById(patient.getPatientId()).get();
			p.setPatientName(patient.getPatientName());
			p.setGender(patient.getGender());
			p.setAddress(patient.getAddress());
			p.setPatientMobile(patient.getPatientMobile());
			p.setPatientEmail(patient.getPatientEmail());
			p.setPatientAge(patient.getPatientAge());
			p.setPatientPassword(patient.getPatientPassword());
			p.setPatientDOB(patient.getPatientDOB());
			patientRepository.save(p);
			return p;
		}
		else {
			log.error("Patient not found exception thrown");
			throw new PatientIdNotFoundException("Patient Not Found");
		}
	}

	@Override
	public Patient deletePatient(int patientId) throws PatientIdNotFoundException {
		if(patientRepository.existsById(patientId)) {
			log.info("Patient deleted");
			Patient pat = patientRepository.findById(patientId).get();
			patientRepository.delete(pat);
			return pat;
		}
		else {
			log.info("Patient not found exception thrown");
			throw new PatientIdNotFoundException("Patient Not Found");
		}
	}

	@Override
	public List<Patient> viewPatientList() throws PatientIdNotFoundException {
		List<Patient> patList = patientRepository.findAll();
		if(patList.isEmpty()) {
			log.error("Patient not found exception thrown");
			throw new PatientIdNotFoundException("No Patients Found");
		}
		log.info("All patients viewed");
		return patList;
	}

	@Override
	public Patient viewPatient(int patientId) throws PatientIdNotFoundException {
		if(patientRepository.existsById(patientId)) {
			log.info("Patient viewed");
			Patient pat = patientRepository.findById(patientId).get();
			return pat;
		}
		else{
			log.error("Patient not found exception thrown");
			throw new PatientIdNotFoundException("Patient Not Found");		
		}
	}
}
