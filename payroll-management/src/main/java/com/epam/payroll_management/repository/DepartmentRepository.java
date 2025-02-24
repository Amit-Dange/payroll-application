package com.epam.payroll_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epam.payroll_management.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

	Optional<Department> findByDepartmentName(String departmentName);

}
