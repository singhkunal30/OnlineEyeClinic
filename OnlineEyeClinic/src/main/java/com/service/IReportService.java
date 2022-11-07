package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Report;
import com.dto.Spectacles;
import com.exceptions.PatientIdFoundNotException;
import com.exceptions.ReportIdNotFoundException;

@Service
public interface IReportService {
	Report addReport(Report report);

	Report updateReport(Report report);

	Report removeReport(int reportId)throws ReportIdNotFoundException;

	Report viewReport(int reportId, int patientId)throws ReportIdNotFoundException,PatientIdFoundNotException;

	List<Report> viewAllReport(LocalDate date);

	List<Spectacles>  viewSpetacles();
}
