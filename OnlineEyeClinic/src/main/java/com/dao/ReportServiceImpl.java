package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Report;
import com.dto.Spectacles;
import com.exceptions.PatientIdFoundNotException;
import com.exceptions.ReportIdNotFoundException;
import com.repository.IReportRepository;
import com.repository.ISpectaclesRepository;
import com.service.IReportService;

@Service
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private IReportRepository reportRepository;
	
	@Autowired
	private ISpectaclesRepository specsRepository;
	
	@Override
	public Report addReport(Report report) {
		return reportRepository.save(report);
	}

	@Override
	public Report updateReport(Report report) {
		Report r = reportRepository.findById(report.getReportId()).get();
		r.setDateOfReport(report.getDateOfReport());
		r.setDescriptionOfReport(report.getDescriptionOfReport());
		r.setPatientId(report.getPatientId());
		r.setSpectaclesId(report.getSpectaclesId());
		r.getTestList().clear();
		r.getTestList().addAll(report.getTestList());
		r.setVisualAcuity(report.getVisualAcuity());
		r.setVisualAcuityDistance(report.getVisualAcuityDistance());
		r.setVisualAcuityNear(report.getVisualAcuityNear());
		reportRepository.save(r);
		return r;
	}

	@Override
	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		Report r = reportRepository.findById(reportId).get();
		reportRepository.deleteById(reportId);
		return r;
	}

	@Override
	public Report viewReport(int reportId, int patientId) throws ReportIdNotFoundException, PatientIdFoundNotException {
		return reportRepository.viewReport(reportId, patientId);
	}

	@Override
	public List<Report> viewAllReport(LocalDate date) {
		return reportRepository.viewByDate(date);
	}

	@Override
	public List<Spectacles> viewSpetacles() {
		return specsRepository.findAll();
	}

}
