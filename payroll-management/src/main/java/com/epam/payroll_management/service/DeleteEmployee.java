package com.epam.payroll_management.service;

import org.springframework.stereotype.Service;

import com.epam.payroll_management.repository.DepartmentRepository;
import com.epam.payroll_management.repository.DesignationRepository;
import com.epam.payroll_management.repository.EmployeeRepository;

import jakarta.transaction.Transactional;


@Service
public class DeleteEmployee {
	
	private final EmployeeRepository employeeRepository ;
	private final DepartmentRepository departmentRepository ;
	private final DesignationRepository designationRepository;
	
    public DeleteEmployee(EmployeeRepository employeeRepository,
    		DepartmentRepository departmentRepository,
    		DesignationRepository designationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository ;
        this.designationRepository = designationRepository;
    }
	
    @Transactional
	public void deleteEmployeeById(int empId) {
		employeeRepository.deleteById(empId);
	}
}
