package com.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(generator = "appSeq")
	@SequenceGenerator( name ="appSeq", sequenceName = "APPSEQ", allocationSize = 1 , initialValue =1001)
	private int appointmentId;
	private LocalDate dateOfAppointment;
	private LocalTime timeOfAppointment;
	private double consultationFee;
	@ManyToOne(cascade = CascadeType.ALL)
	private Doctor doctorId;
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patientId;
	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	public LocalTime getTimeOfAppointment() {
		return timeOfAppointment;
	}
	public void setTimeOfAppointment(LocalTime timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}
	public double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	public Doctor getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Doctor doctorId) {
		this.doctorId = doctorId;
	}
	public Patient getPatientId() {
		return patientId;
	}
	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	
}
