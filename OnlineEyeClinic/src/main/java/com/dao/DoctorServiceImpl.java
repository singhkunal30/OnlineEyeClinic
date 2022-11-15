package com.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Appointment;
import com.dto.Doctor;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.DoctorIdNotFoundException;
import com.repository.IfcAppointmentRepository;
import com.repository.IfcDoctorRepository;
import com.service.IfcDoctorService;
import org.springframework.stereotype.Service;
@Service
public class DoctorServiceImpl implements IfcDoctorService{
	
	@Autowired
	private IfcDoctorRepository doctorRepository;
	@Autowired
	private IfcAppointmentRepository appointmentRepository;
	
	Logger log = LoggerFactory.getLogger(DoctorServiceImpl.class);
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		log.info("Doctor added");
		return doctorRepository.save(doctor);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException {
		if(doctorRepository.existsById(doctor.getDoctorId())) {
			log.info("Doctor updated");
			Doctor doc = doctorRepository.findById(doctor.getDoctorId()).get();
			doc.setDoctorName(doctor.getDoctorName());
			doc.setDoctorMobile(doctor.getDoctorMobile());
			doc.setDoctorId(doctor.getDoctorId());
			doc.setDoctorEmail(doctor.getDoctorEmail());
			doc.setAddress(doctor.getAddress());
			doc.setPassword(doctor.getPassword());
			doctorRepository.save(doc);
			return doc;
		}
		else {
			log.error("Doctor not found exception thrown");
			throw new DoctorIdNotFoundException("Doctor Not Found");		
		}
	}

	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException {
		if(doctorRepository.existsById(doctorId)) {
			log.info("Doctor deleted");
			Doctor doc = doctorRepository.findById(doctorId).get();
			doctorRepository.deleteById(doctorId);
			return doc;
		}
		else {
			log.info("Doctor not found exception thrown");
			throw new DoctorIdNotFoundException("Doctor Not Found");
		}
	}

	@Override
	public Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException {
		if(doctorRepository.existsById(doctorId)) {
			log.info("Doctor viewed");
			Doctor doc = doctorRepository.findById(doctorId).get();
			return doc;
		}
		else {
			log.error("Doctor not found exception thrown");
			throw new DoctorIdNotFoundException("Doctor Not Found");
		}
	}

	@Override
	public List<Doctor> viewDoctorsList() throws DoctorIdNotFoundException {
		List<Doctor> list = doctorRepository.findAll();
		if(list.isEmpty()) { 
			log.error("Doctor not found exception thrown");
			throw new DoctorIdNotFoundException("No Doctors Found");
		}
		log.info("All doctors viewed");
		return list;
	}

	@Override
	public List<Appointment> viewAppointments(int doctorId) throws AppointmentIdNotFoundException{
		List<Appointment> list = appointmentRepository.viewByDoctorId(doctorId);
		if(list.isEmpty()) {
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("No Appointments found");
		}
		log.info("All appointments for "+doctorId+" viewed");
		return list;
	}

}
