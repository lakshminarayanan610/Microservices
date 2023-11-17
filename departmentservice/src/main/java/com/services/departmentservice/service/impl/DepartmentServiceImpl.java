package com.services.departmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.services.departmentservice.dto.DepartmentDTO;
import com.services.departmentservice.entity.Department;
import com.services.departmentservice.repository.DepartmentRepository;
import com.services.departmentservice.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDto) {
		Department department = new Department(departmentDto.getId(), 
				                               departmentDto.getDepartmentName(), 
				                               departmentDto.getDepartmentDescription(), 
				                               departmentDto.getDepartmentCode());
		
		Department savedDepartment = departmentRepo.save(department);
		
		DepartmentDTO savedDepartmentDto = new DepartmentDTO(savedDepartment.getId(), 
				                                             savedDepartment.getDepartmentName(), 
				                                             savedDepartment.getDepartmentDescription(), 
				                                             savedDepartment.getDepartmentCode());
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDTO getDepartmentByCode(String departmentCode) {
		Department department = departmentRepo.findByDepartmentCode(departmentCode);
		return new DepartmentDTO(department.getId(),
				                 department.getDepartmentName(),
				                 department.getDepartmentDescription(),
				                 department.getDepartmentCode());
	}

}