package com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Admin;
import com.repository.IfcAdminRepository;
import com.service.IfcAdminService;
@Service
public class AdminServiceImpl implements IfcAdminService{
	
	@Autowired
	private IfcAdminRepository adminRepository;
	
	Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);
	
	@Override
	public Admin addAdmin(Admin admin) {
		log.info("Admin added");
		return adminRepository.save(admin);
	}
	
	@Override
	public Admin updateAdmin(Admin admin) {
		Admin a = adminRepository.findById(admin.getAdminId()).get();
		a.setAdminUsername(admin.getAdminUsername());
		a.setAdminPassword(admin.getAdminPassword());
		adminRepository.save(a);
		log.info("Admin updated");
		return a;
	}
}
