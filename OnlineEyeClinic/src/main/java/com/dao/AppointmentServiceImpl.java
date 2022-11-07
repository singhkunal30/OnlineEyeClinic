package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Appointment;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.InvalidAppointmentException;
import com.repository.IAppointmentRepository;
import com.service.IAppointmentService;

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	
	@Autowired
	private IAppointmentRepository appointmentRepository;
	
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) throws InvalidAppointmentException {
		Appointment apt = appointmentRepository.findById(appointment.getAppointmentId()).get();
		apt.setConsultationFee(appointment.getConsultationFee());
		apt.setDateOfAppointment(appointment.getDateOfAppointment());
		apt.setDoctorId(appointment.getDoctorId());
		apt.setPatientId(appointment.getPatientId());
		apt.setTimeOfAppointment(appointment.getTimeOfAppointment());
		appointmentRepository.save(apt);
		return apt;
	}

	@Override
	public Appointment cancelAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		Appointment apt = appointmentRepository.findById(appointmentId).get();
		appointmentRepository.deleteById(appointmentId);
		return apt;
	}

	@Override
	public Appointment viewAppointment(int appointmentId) throws AppointmentIdNotFoundException {
		Appointment apt =  appointmentRepository.findById(appointmentId).get();
		return apt;
	}

	@Override
	public List<Appointment> viewAllAppointments() {
		return appointmentRepository.findAll();
	}

	@Override
	public List<Appointment> viewAppointments(LocalDate date) {
		return appointmentRepository.viewByDate(date);
	}

}
