package com.services.employmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.services.employmentservice.dto.APIResponseDTO;
import com.services.employmentservice.dto.DepartmentDTO;
import com.services.employmentservice.dto.EmployeeDTO;
import com.services.employmentservice.entity.Employee;
import com.services.employmentservice.repository.EmployeeRepository;
import com.services.employmentservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	//@Autowired
	//private RestTemplate restTemplate;

	@Autowired
	private WebClient webClient;
	
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDto) {
		Employee employee = new Employee(employeeDto.getId(),
				employeeDto.getFirstName(), 
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode());
		Employee savedEmployee = employeeRepo.save(employee);
		
		return new EmployeeDTO(savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail(),
				savedEmployee.getDepartmentCode());
	}

	@Override
	public APIResponseDTO getEmployeeById(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).get();
		
		//DepartmentDTO departmentDto = restTemplate.getForObject("http://localhost:8080/api/v1/departments/getDepartmentByCode/"+employee.getDepartmentCode(), DepartmentDTO.class);
		
		DepartmentDTO departmentDto = webClient.get().uri("http://localhost:8080/api/v1/departments/getDepartmentByCode/"+employee.getDepartmentCode())
				                                     .retrieve()
				                                     .bodyToMono(DepartmentDTO.class)
				                                     .block();
		
		EmployeeDTO employeeDto = new EmployeeDTO(employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode());
		
		APIResponseDTO apiResponse = new APIResponseDTO();
		apiResponse.setDepartmentDto(departmentDto);
		apiResponse.setEmployeeDto(employeeDto);
		
		return apiResponse;
	}

}
