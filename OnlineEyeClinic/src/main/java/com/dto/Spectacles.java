package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Spectacles {
	@Id
	@GeneratedValue(generator = "specSeq")
	@SequenceGenerator( name ="specSeq", sequenceName = "SPECSEQ", allocationSize = 1 , initialValue =4001)
	private int spectaclesId;
	private String spectaclesModel;
	private String spectaclesDescription;
	private double spectaclesCost;
	@OneToOne(mappedBy = "spectaclesId")
	private Report reportId;
	public Report getReportId() {
		return reportId;
	}
	public void setReportId(Report reportId) {
		this.reportId = reportId;
	}
	public int getSpectaclesId() {
		return spectaclesId;
	}
	public void setSpectaclesId(int spectaclesId) {
		this.spectaclesId = spectaclesId;
	}
	public String getSpectaclesModel() {
		return spectaclesModel;
	}
	public void setSpectaclesModel(String spectaclesModel) {
		this.spectaclesModel = spectaclesModel;
	}
	public String getSpectaclesDescription() {
		return spectaclesDescription;
	}
	public void setSpectaclesDescription(String spectaclesDescription) {
		this.spectaclesDescription = spectaclesDescription;
	}
	public double getSpectaclesCost() {
		return spectaclesCost;
	}
	public void setSpectaclesCost(double spectaclesCost) {
		this.spectaclesCost = spectaclesCost;
	}
}
