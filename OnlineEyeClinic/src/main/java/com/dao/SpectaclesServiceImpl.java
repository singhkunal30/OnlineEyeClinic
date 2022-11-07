package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Spectacles;
import com.repository.ISpectaclesRepository;
import com.service.ISpectaclesService;

@Service
public class SpectaclesServiceImpl implements ISpectaclesService{
	
	@Autowired
	private ISpectaclesRepository spectaclesRepository;
	@Override
	public List<Spectacles> viewAll() {
		return spectaclesRepository.findAll();
	}
	@Override
	public Spectacles getByReportId(int patientId) {
		return spectaclesRepository.findById(patientId).get();
	}
	@Override
	public Spectacles getBySpectaclesId(int specId) {
		return spectaclesRepository.findById(specId).get();
	}

}
