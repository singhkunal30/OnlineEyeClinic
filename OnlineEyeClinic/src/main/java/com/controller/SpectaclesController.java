package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.service.ISpectaclesService;

@RestController
public class SpectaclesController {
	
	@Autowired
	private ISpectaclesService specsService;
	
}
