package com.services.employmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.employmentservice.dto.APIResponseDTO;
import com.services.employmentservice.dto.EmployeeDTO;
import com.services.employmentservice.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
	
	@Autowired EmployeeService employeeService;
	
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDto) {
		return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/getEmployeeById/{employeeId}")
	public ResponseEntity<APIResponseDTO> getEMployeeById(@PathVariable Long employeeId) {
		return new ResponseEntity<>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}

}
