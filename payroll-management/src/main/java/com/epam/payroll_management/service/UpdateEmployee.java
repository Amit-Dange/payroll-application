package com.epam.payroll_management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.epam.payroll_management.entity.Department;
import com.epam.payroll_management.entity.Designation;
import com.epam.payroll_management.entity.Employee;
import com.epam.payroll_management.repository.DepartmentRepository;
import com.epam.payroll_management.repository.DesignationRepository;
import com.epam.payroll_management.repository.EmployeeRepository;

import jakarta.transaction.Transactional;


@Service
public class UpdateEmployee {
	
	private final EmployeeRepository employeeRepository ;
	private final DepartmentRepository departmentRepository ;
	private final DesignationRepository designationRepository;
	
    public UpdateEmployee(EmployeeRepository employeeRepository,
    		DepartmentRepository departmentRepository,
    		DesignationRepository designationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository ;
        this.designationRepository = designationRepository;
    }
	
    @Transactional
    public Employee updateEmployeeById(int empId, String desig, String depart) {
        
    	Designation designation = designationRepository.findByDesignationName(desig)
    			.orElseThrow(() -> new IllegalArgumentException("Designation '" + desig + "' does not exist."));
    	Department department = departmentRepository.findByDepartmentName(depart)
    			.orElseThrow(() -> new IllegalArgumentException("Department '" + depart + "' does not exist."));
    	
        Optional<Employee> optionalEmployee = employeeRepository.findById(empId);
        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee with ID " + empId + " not found");
        }
        
		Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setDesignation(designation);
        existingEmployee.setDepartment(department);
        return employeeRepository.save(existingEmployee);
    }
	
}
