package com.services.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByDepartmentCode(String code);

}
