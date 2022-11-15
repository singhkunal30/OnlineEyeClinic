package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Report;
import com.exceptions.PatientIdNotFoundException;
import com.exceptions.ReportIdNotFoundException;
@Service
public interface IfcReportService {
	Report addReport(Report report);
	Report updateReport(Report report) throws ReportIdNotFoundException;
	Report removeReport(int reportId)throws ReportIdNotFoundException;
	Report viewReportByReportId(int reportId)throws ReportIdNotFoundException;
	List<Report> viewReportsByPatientId(int patientId) throws ReportIdNotFoundException,PatientIdNotFoundException;
	List<Report> viewReportsByDate(LocalDate date) throws ReportIdNotFoundException;
}
