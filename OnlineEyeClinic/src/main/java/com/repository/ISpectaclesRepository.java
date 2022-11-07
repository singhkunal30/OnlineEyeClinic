package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.Spectacles;

@Repository
public interface ISpectaclesRepository extends JpaRepository<Spectacles, Integer> {

}
