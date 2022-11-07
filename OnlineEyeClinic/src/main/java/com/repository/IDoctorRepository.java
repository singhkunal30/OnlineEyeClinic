package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.Doctor;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer>{
}
