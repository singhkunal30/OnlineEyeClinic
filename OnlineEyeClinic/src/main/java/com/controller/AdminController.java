package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.dto.*;
import com.service.IfcAdminService;

@RestController
@CrossOrigin("*")
public class AdminController {
	
	@Autowired
	private IfcAdminService adminService;
	
	@PostMapping(path="admin/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@PutMapping(path="admin/update")
	public Admin updateAdmin(@RequestBody Admin admin) {
		return adminService.updateAdmin(admin);
	}	
}
