package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.Report;

@Repository
public interface IReportRepository extends JpaRepository<Report, Integer>{
	@Query(value = "select r from Report r where dateOfReport = ?1")
	public List<Report> viewByDate(LocalDate date);
	
	@Query(value = "select r from Report r where r.reportId =?1, r.patientId=?2")
	public Report viewReport(int reportId, int patientId);
}
