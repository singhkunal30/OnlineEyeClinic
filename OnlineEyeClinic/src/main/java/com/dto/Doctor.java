package com.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(generator = "docSeq")
	@SequenceGenerator( name ="docSeq", sequenceName = "DOCSEQ", allocationSize = 1 , initialValue =101)
	private int doctorId;
	private String doctorName;
	private String doctorConsultationTime;
	private long doctorMobile;
	private String doctorEmail;
	private String userName;
	private String password;
	private String address;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Test> testList;
	@OneToMany(mappedBy = "doctorId", cascade  = CascadeType.ALL)
	private List<Appointment> docAptList;
	public List<Test> getTestList() {
		return testList;
	}
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}
	public List<Appointment> getDocAptList() {
		return docAptList;
	}
	public void setDocAptList(List<Appointment> docAptList) {
		this.docAptList = docAptList;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}
	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}
	public long getDoctorMobile() {
		return doctorMobile;
	}
	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}
	public String getDoctorEmail() {
		return doctorEmail;
	}
	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
