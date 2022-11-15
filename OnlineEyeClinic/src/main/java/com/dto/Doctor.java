package com.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Doctor {
	@Id
	@GeneratedValue(generator = "docSeq")
	@SequenceGenerator(name = "docSeq", sequenceName="DOCSEQ", allocationSize=1, initialValue=101)
	private int doctorId;
	private String doctorName;
	private long doctorMobile;
	private String doctorEmail;
	private String password;
	private String address;
//	@JsonBackReference(value = "aptDocBackRef")
	@OneToMany(mappedBy="doctorId")
	@JsonIgnore
	private List<Appointment> docAptList = new ArrayList<>();

//	@JsonBackReference(value = "testDocManageRef")
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "doctor_test")
	private List<Test> docTestList = new ArrayList<>();
	public Doctor() {
		super();
	}
	public List<Test> getDocTestList() {
		return docTestList;
	}
	public void setDocTestList(List<Test> docTestList) {
		this.docTestList = docTestList;
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
