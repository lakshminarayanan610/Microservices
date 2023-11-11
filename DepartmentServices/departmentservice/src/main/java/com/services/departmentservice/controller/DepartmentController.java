package com.services.departmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.departmentservice.dto.DepartmentDTO;
import com.services.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/saveDepartment")
	public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDto) {
		
		return new ResponseEntity<>(departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getDepartmentByCode/{departmentCode}")
	public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String departmentCode) {
		return new ResponseEntity<>(departmentService.getDepartmentByCode(departmentCode), HttpStatus.OK);
	}
}
