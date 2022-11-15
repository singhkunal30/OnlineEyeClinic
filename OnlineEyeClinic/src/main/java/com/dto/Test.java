package com.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Test {
	@Id
	@GeneratedValue(generator = "testSeq")
	@SequenceGenerator(name = "testSeq", sequenceName="TESTSEQ", allocationSize=1, initialValue=5001)
	private int testId;
	private String testName;
	private String testType;
	private double testCost;
//	@JsonBackReference(value="rptTestManageRef")
	@ManyToMany(mappedBy = "testList")
	@JsonIgnore
	private List<Report> reportList;
//	@JsonBackReference(value = "docTestBackRef")
	@ManyToMany(mappedBy = "docTestList")
	@JsonIgnore
	private List<Doctor> docList;
	public Test() {
		super();
	}	
	public List<Doctor> getDocList() {
		return docList;
	}
	public void setDocList(List<Doctor> docList) {
		this.docList = docList;
	}
	public List<Report> getReportList() {
		return reportList;
	}
	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public double getTestCost() {
		return testCost;
	}
	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}
}
