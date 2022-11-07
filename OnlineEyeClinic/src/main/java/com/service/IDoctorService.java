package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Appointment;
import com.dto.Doctor;
import com.dto.Test;

@Service
public interface IDoctorService {
	Doctor addDoctor(Doctor doctor);
	Doctor updateDoctor(Doctor doctor);
	Doctor deleteDoctor(int doctorId);
	Doctor viewDoctor(int doctorId);
	List<Doctor> viewDoctorsList();
	List<Appointment> viewAppointments();
	Test createTest(Test test);
}
