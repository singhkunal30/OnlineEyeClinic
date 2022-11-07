package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.Test;

@Repository
public interface ITestRepository extends JpaRepository<Test, Integer>{
}
