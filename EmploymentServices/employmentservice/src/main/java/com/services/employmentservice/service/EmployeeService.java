package com.services.employmentservice.service;

import com.services.employmentservice.dto.APIResponseDTO;
import com.services.employmentservice.dto.EmployeeDTO;

public interface EmployeeService {
	
	EmployeeDTO saveEmployee(EmployeeDTO employeeDto);
	
	APIResponseDTO getEmployeeById(Long employeeId);

}
