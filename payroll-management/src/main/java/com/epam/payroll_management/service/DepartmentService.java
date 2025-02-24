package com.epam.payroll_management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.epam.payroll_management.entity.Department;
import com.epam.payroll_management.repository.DepartmentRepository;

@Service
public class DepartmentService {
	DepartmentRepository departmentRepository ;
	
	public DepartmentService(DepartmentRepository departmentRepository ) {
		 this.departmentRepository = departmentRepository ; 
	}
	
	public Department addDepartment(String departmentName , double bonus) {
		Department department = Department.builder()
				.departmentName(departmentName)
				.bonus(bonus)
				.build();
		return departmentRepository.save(department);
	}
	
	public Department deleteDepartment(int id) {
		Optional<Department> department = departmentRepository.findById(id);
		if(department.isEmpty()) {
			throw new IllegalArgumentException("Department Does not Exist");
		}
		departmentRepository.deleteById(id);
		return department.get() ;
	}
	
	
}
