package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.Report;

@Repository
public interface IfcReportRepository extends JpaRepository<Report, Integer> {
	@Query(value="select r from Report r where r.dateOfReport =?1")
	public List<Report> viewByDate(LocalDate date);
	
	@Query(value="select r from Report r left join Patient p on r.patientId.patientId = p.patientId where r.patientId.patientId =?1")
	public List<Report> viewByPatientId(int patientId);
}
