package com.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.Appointment;
@Repository
public interface IfcAppointmentRepository extends JpaRepository<Appointment, Integer>{
	@Query(value="select a from Appointment a where a.dateOfAppointment=?1")
	public List<Appointment> viewByDate(LocalDate date);
	
	@Query(value = "select a from Appointment a left join Doctor d on a.doctorId.doctorId =d.doctorId where d.doctorId=?1")
	public List<Appointment> viewByDoctorId(int doctorId);
	
	@Query(value = "select a from Appointment a left join Patient p on a.patientId =p.patientId where p.patientId=?1")
	public List<Appointment> viewAppointments(int patientId);
}
