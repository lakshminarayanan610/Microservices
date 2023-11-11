package com.services.departmentservice.service;

import com.services.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {

	DepartmentDTO saveDepartment(DepartmentDTO department);
	
	DepartmentDTO getDepartmentByCode(String code);
}
