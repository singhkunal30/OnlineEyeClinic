package com.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dto.Appointment;
import com.dto.Doctor;
import com.dto.Test;
import com.repository.IAppointmentRepository;
import com.repository.IDoctorRepository;
import com.repository.ITestRepository;
import com.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepository doctorRepository;
	
	@Autowired
	private IAppointmentRepository appointmentRepository;
	
	@Autowired
	private ITestRepository testRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		Doctor doc=doctorRepository.findById(doctor.getDoctorId()).get();
		doc.setDoctorName(doctor.getDoctorName());
		doc.setDoctorMobile(doctor.getDoctorMobile());
		doc.setDoctorEmail(doctor.getDoctorEmail());
		doc.setDoctorConsultationTime(doctor.getDoctorConsultationTime());
		doc.setAddress(doctor.getAddress());
		doc.setPassword(doctor.getPassword());
		doc.getTestList().clear();
		doc.getTestList().addAll(doctor.getTestList());
		doc.getDocAptList().clear();
		doc.getDocAptList().addAll(doctor.getDocAptList());
		doc.setUserName(doctor.getUserName());
		doctorRepository.save(doc);
		return doc;
	}

	@Override
	public Doctor deleteDoctor(int doctorId) {
		Doctor doc = doctorRepository.findById(doctorId).get();
		doctorRepository.deleteById(doctorId);
		return doc;
	}

	@Override
	public Doctor viewDoctor(int doctorId) {
		return	doctorRepository.findById(doctorId).get();
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		return doctorRepository.findAll();
	}

	@Override
	public List<Appointment> viewAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public Test createTest(Test test) {
		return testRepository.save(test);
	}	
}
