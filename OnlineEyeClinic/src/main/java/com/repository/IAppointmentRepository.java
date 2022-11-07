package com.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer>{
	@Query(value = "select a from Appointment a where dateOfAppointment =?1")
	public List<Appointment> viewByDate(LocalDate date);
}
