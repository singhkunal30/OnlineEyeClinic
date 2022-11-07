package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Spectacles;

@Service
public interface ISpectaclesService {
	List<Spectacles> viewAll();
	Spectacles getBySpectaclesId(int specId);
	Spectacles getByReportId(int reportId);
}
