package com.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Patient {
	@Id
	@GeneratedValue(generator = "patSeq")
	@SequenceGenerator( name ="patSeq", sequenceName = "PATSEQ", allocationSize = 1 , initialValue = 2001)
	private int patientId;
	private String patientName;
	private int patientAge;
	private long patientMobile;
	private String patientEmail;
	private LocalDate patientDOB;
	private String patientUserName;
	private String patientPassword;
	private String address;
	@OneToMany(mappedBy = "patientId", cascade = CascadeType.ALL)
	private List<Report> patReportList;
	@OneToMany(mappedBy = "patientId", cascade  = CascadeType.ALL)
	private List<Appointment> patAptList;
	public List<Report> getPatReportList() {
		return patReportList;
	}

	public void setPatReportList(List<Report> patReportList) {
		this.patReportList = patReportList;
	}

	public List<Appointment> getPatAptList() {
		return patAptList;
	}

	public void setPatAptList(List<Appointment> patAptList) {
		this.patAptList = patAptList;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public long getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public LocalDate getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}

	public String getPatientUserName() {
		return patientUserName;
	}

	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}

	public String getPatientPassword() {
		return patientPassword;
	}

	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
