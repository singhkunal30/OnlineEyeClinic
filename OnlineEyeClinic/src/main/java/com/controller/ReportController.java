package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.IReportService;

@RestController
public class ReportController {
	
	@Autowired
	private IReportService reportService;
}
