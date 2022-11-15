package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Appointment;
import com.dto.Doctor;
import com.exceptions.AppointmentIdNotFoundException;
import com.exceptions.DoctorIdNotFoundException;

@Service
public interface IfcDoctorService {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException;
	Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException;
	Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException;
	List<Doctor> viewDoctorsList() throws DoctorIdNotFoundException;
	List<Appointment> viewAppointments(int doctorId) throws AppointmentIdNotFoundException;
}
