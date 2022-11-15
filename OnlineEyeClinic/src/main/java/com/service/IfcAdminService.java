package com.service;

import org.springframework.stereotype.Service;
import com.dto.Admin;
@Service
public interface IfcAdminService {
	Admin addAdmin(Admin admin);
	Admin updateAdmin(Admin admin);
}
