package com.epam.payroll_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.payroll_management.entity.Designation;
import com.epam.payroll_management.entity.Employee;
import com.epam.payroll_management.repository.DepartmentRepository;
import com.epam.payroll_management.repository.DesignationRepository;
import com.epam.payroll_management.repository.EmployeeRepository;

@Service
public class DatabaseSummary {
	
	private final EmployeeRepository employeeRepository ;
	private final DepartmentRepository departmentRepository ;
	private final DesignationRepository designationRepository;
	
    public DatabaseSummary(EmployeeRepository employeeRepository,
    		DepartmentRepository departmentRepository,
    		DesignationRepository designationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository ;
        this.designationRepository = designationRepository;
    }
    
	
	public int totalEmployees() {
		return employeeRepository.findAll().size() ;
	}
	
	public int totalDepartments() {
		return departmentRepository.findAll().size() ;
	}
	
	public int totalDesignations() {
		return designationRepository.findAll().size() ;
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll() ;
	}
	
	public List<Designation> getAllDepartmentsName(){
		return designationRepository.findAll() ;
	}
	
	public List<Designation> getAllDesignations(){
		return designationRepository.findAll() ;
	}
	
	public Employee getEmployeeById(int empId) {
		return employeeRepository.findById(empId).orElseThrow();
	}
	
}
