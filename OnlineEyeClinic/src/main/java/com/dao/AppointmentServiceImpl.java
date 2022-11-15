package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Appointment;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.InvalidAppointmentException;
import com.repository.IfcAppointmentRepository;
import com.service.IfcAppointmentService;
import org.springframework.stereotype.Service;
@Service
public class AppointmentServiceImpl implements IfcAppointmentService {
	@Autowired
	private IfcAppointmentRepository appointmentRepository;
	
	Logger log = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		log.info("Appointment booked");
		return appointmentRepository.save(appointment);
	}
	
	@Override
	public Appointment updateAppointment(Appointment appointment) throws InvalidAppointmentException, AppointmentIdNotFoundException {
		if(appointmentRepository.existsById(appointment.getAppointmentId())) {
			if(appointment.getDateOfAppointment().isBefore(LocalDate.now())) {
				log.error("Invalid appointment date exception thrown");
				throw new InvalidAppointmentException("Invalid Appointment Date");
			}
			else {
				log.info("Appointment updated");
				Appointment apt = appointmentRepository.findById(appointment.getAppointmentId()).get();
				apt.setConsultationFee(appointment.getConsultationFee());
				apt.setDateOfAppointment(appointment.getDateOfAppointment());
				apt.setDoctorId(appointment.getDoctorId());
				apt.setTimeOfAppointment(appointment.getTimeOfAppointment());
				apt.setPatientId(appointment.getPatientId());
				appointmentRepository.save(apt);
				return apt;
			}
		}
		else {
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("Appointment Not Found");
		}
	}

	@Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		if(appointmentRepository.existsById(appointmentId)) {
			log.info("Appointment deleted");
			Appointment apt = appointmentRepository.findById(appointmentId).get();
			appointmentRepository.deleteById(appointmentId);
			return apt;
		}
		else{
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("Appointment Not Found");
		}
	}

	@Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		if(appointmentRepository.existsById(appointmentId)) {
			log.info("Appointment viewed");
			Appointment apt = appointmentRepository.findById(appointmentId).get(); 
			return apt;
		}
		else {
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("Appointment Not Found");
		}
	}

	@Override
	public List<Appointment> viewAllAppointments() throws AppointmentIdNotFoundException {
		List<Appointment> aptList = appointmentRepository.findAll();
		if(aptList.isEmpty()) {
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("No Appointments Found");
		}
		log.info("All appointments viewed");
		return aptList;
	}

	@Override
	public List<Appointment> viewAppointmentsByDate(LocalDate date) throws AppointmentIdNotFoundException {
		List<Appointment> aptList = appointmentRepository.viewByDate(date);
		if(aptList.isEmpty()) {
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("No Appointments On " + date.toString());
		}
		log.info("All Appointments for "+date+" viewed");
		return aptList;
	}

	@Override
	public List<Appointment> viewAppointmentByPatientId(int patientId) throws AppointmentIdNotFoundException {
		if(appointmentRepository.viewAppointments(patientId).isEmpty()) {
			log.error("Appointment not found exception thrown");
			throw new AppointmentIdNotFoundException("No appointments found");
		}
		log.info("Appointments viewed by patient");
		return appointmentRepository.viewAppointments(patientId);
	}

}
