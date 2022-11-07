package com.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
public class Report {
	@Id
	@GeneratedValue(generator = "reportSeq")
	@SequenceGenerator( name ="reportSeq", sequenceName = "REPORTSEQ", allocationSize = 1 , initialValue = 3001)
	private int reportId;
	private LocalDateTime dateOfReport;
	private String descriptionOfReport;
	private String visualAcuity;
	private String visualAcuityNear;
	private String visualAcuityDistance;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Test> testList;
	@ManyToOne(cascade = CascadeType.ALL)
	private Patient patientId;
	@OneToOne(cascade = CascadeType.ALL)
	private Spectacles spectaclesId;
	public Spectacles getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(Spectacles spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public LocalDateTime getDateOfReport() {
		return dateOfReport;
	}
	public void setDateOfReport(LocalDateTime dateOfReport) {
		this.dateOfReport = dateOfReport;
	}
	public String getDescriptionOfReport() {
		return descriptionOfReport;
	}
	public void setDescriptionOfReport(String descriptionOfReport) {
		this.descriptionOfReport = descriptionOfReport;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getVisualAcuityNear() {
		return visualAcuityNear;
	}
	public void setVisualAcuityNear(String visualAcuityNear) {
		this.visualAcuityNear = visualAcuityNear;
	}
	public String getVisualAcuityDistance() {
		return visualAcuityDistance;
	}
	public void setVisualAcuityDistance(String visualAcuityDistance) {
		this.visualAcuityDistance = visualAcuityDistance;
	}
	public Patient getPatientId() {
		return patientId;
	}
	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}
	public List<Test> getTestList() {
		return testList;
	}
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}
}
