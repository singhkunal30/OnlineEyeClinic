package com.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.dto.Report;
import com.exceptions.*;
import com.service.IfcReportService;

@RestController
@CrossOrigin("*")
public class ReportController {
	@Autowired
	private IfcReportService reportService;

	@PostMapping(path="report/add")
	public Report addReport(@RequestBody Report report) {
		return reportService.addReport(report);
	}
	
    @PutMapping(path="report/update")
	public Report updateReport(@RequestBody Report report) throws ReportIdNotFoundException{
    	return reportService.updateReport(report);
    }

    @DeleteMapping(path="report/delete/{reportId}")
	public Report removeReport(@PathVariable int reportId)throws ReportIdNotFoundException{
    	return reportService.removeReport(reportId);
    }

    @GetMapping(path="report/viewAll/{date}")
	public List<Report> viewReportsByDate(@PathVariable String date) throws ReportIdNotFoundException{
    	LocalDate d1 = LocalDate.parse(date);
    	return reportService.viewReportsByDate(d1);
    }
    
    @GetMapping(path = "report/viewByReportId/{reportId}")
    public Report viewReportByReportId(@PathVariable int reportId) throws ReportIdNotFoundException{
		return reportService.viewReportByReportId(reportId);
    }
    
    @GetMapping(path = "report/viewByPatientId/{patientId}")
	public List<Report> viewReportsByPatientId(@PathVariable int patientId) throws ReportIdNotFoundException, PatientIdNotFoundException {
		return reportService.viewReportsByPatientId(patientId);
	}
}
