package com.services.employmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.employmentservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
