package com.services.employmentservice.dto;

public class APIResponseDTO {
	private DepartmentDTO departmentDto;
	private EmployeeDTO employeeDto;
	
	public APIResponseDTO(DepartmentDTO departmentDto, EmployeeDTO employeeDto) {
		super();
		this.departmentDto = departmentDto;
		this.employeeDto = employeeDto;
	}
	
	public APIResponseDTO() {}
	
	public DepartmentDTO getDepartmentDto() {
		return departmentDto;
	}
	public void setDepartmentDto(DepartmentDTO departmentDto) {
		this.departmentDto = departmentDto;
	}
	public EmployeeDTO getEmployeeDto() {
		return employeeDto;
	}
	public void setEmployeeDto(EmployeeDTO employeeDto) {
		this.employeeDto = employeeDto;
	}
}
