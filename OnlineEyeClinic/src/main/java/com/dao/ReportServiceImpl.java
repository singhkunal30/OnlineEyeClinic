package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Report;
import com.exceptions.PatientIdNotFoundException;
import com.exceptions.ReportIdNotFoundException;
import com.repository.IfcPatientRepository;
import com.repository.IfcReportRepository;
import com.service.IfcReportService;
import org.springframework.stereotype.Service;
@Service
public class ReportServiceImpl implements IfcReportService {
	
	@Autowired
	private IfcReportRepository reportRepository;
	@Autowired
	private IfcPatientRepository patientRepository;
	
	Logger log = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	@Override
	public Report addReport(Report report) {
		log.info("Report added");
		return reportRepository.save(report);
	}

	@Override
	public Report updateReport(Report report) throws ReportIdNotFoundException{
		if(reportRepository.existsById(report.getReportId())) {
			Report r = reportRepository.findById(report.getReportId()).get();
			r.setDateOfReport(report.getDateOfReport());
			r.setDescriptionOfReport(report.getDescriptionOfReport());
			r.setVisualAcuity(report.getVisualAcuity());
			r.setVisualAcuityDistance(report.getVisualAcuityDistance());
			r.setVisualAcuityNear(report.getVisualAcuityNear());
			reportRepository.save(r);
			log.info("Report updated");
			return r;
		}
		else {
			log.error("Report not found exception thrown");
			throw new ReportIdNotFoundException("Report Not Found");
		}
	}

	@Override
	public Report removeReport(int reportId) throws ReportIdNotFoundException {
		if(reportRepository.existsById(reportId)) {
			Report r = reportRepository.findById(reportId).get();
			reportRepository.deleteById(reportId);
			log.info("Report removed");
			return r;
		}
		else {
			log.error("Report not found exception thrown");
			throw new ReportIdNotFoundException("Report Not Found");
		}
	}

	@Override
	public Report viewReportByReportId(int reportId) throws ReportIdNotFoundException {
		if(reportRepository.existsById(reportId)) {
			log.info("Report viewed");
			return reportRepository.findById(reportId).get();
		}
		else {
			log.error("Report not found exception thrown");
			throw new ReportIdNotFoundException("Report Not Found");
		}
	}
		
	@Override
	public List<Report> viewReportsByPatientId(int patientId) throws ReportIdNotFoundException,PatientIdNotFoundException{
		if(patientRepository.existsById(patientId)) {
			List<Report> list = reportRepository.viewByPatientId(patientId);
			if(list.isEmpty()) {
				log.error("Report not found exception thrown");
				throw new ReportIdNotFoundException("No Reports Found");
			}
			else {
				log.info("All Reports viewed");
				return list;
			}
		}
		else {
			log.error("Patient not found exception thrown");
			throw new PatientIdNotFoundException("No Patient Found");
		}
	}

	@Override
	public List<Report> viewReportsByDate(LocalDate date) throws ReportIdNotFoundException {
		if(reportRepository.viewByDate(date).isEmpty())	{
			log.error("Report not found exception thrown");
			throw new ReportIdNotFoundException("No Reports Found");
		}
		else {
			log.info("Reports of "+date+" viewed");
			return reportRepository.viewByDate(date);
		}
	}
}
