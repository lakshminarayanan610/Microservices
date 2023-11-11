package com.services.employmentservice.service;

import com.services.employmentservice.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO saveEmployee(EmployeeDTO employeeDto);
	
	EmployeeDTO getEmployeeById(Long employeeId);

}
