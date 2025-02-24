package com.epam.payroll_management.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epam.payroll_management.entity.Department;
import com.epam.payroll_management.entity.Designation;
import com.epam.payroll_management.entity.Employee;
import com.epam.payroll_management.repository.DepartmentRepository;
import com.epam.payroll_management.repository.DesignationRepository;
import com.epam.payroll_management.repository.EmployeeRepository;

@Service
public class CreateEmployee {
	
	private final EmployeeRepository employeeRepository ;
	private final DepartmentRepository departmentRepository ;
	private final DesignationRepository designationRepository;
	
    public CreateEmployee(EmployeeRepository employeeRepository,
    		DepartmentRepository departmentRepository,
    		DesignationRepository designationRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository ;
        this.designationRepository = designationRepository;
    }
    
	public LocalDate getLocalDate(String localDate){
		if("NOW".equals(localDate)) {
			return LocalDate.now();
		}
		LocalDate date=null;    
		try {        
			date=  LocalDate.parse(localDate);    
		}
		
		catch (Exception e) {
			System.out.println("Invalid date format. Please use yyyy-MM-dd.");    
		}    
		return date;
	}

	public Employee addEmployee(String name, String desig, String depart, String localdate) {
		
//		Designation designation = Designation.builder()
//				.designation_name(desig)
//				.build();
//		Department department = Department.builder()
//				.department(depart)
//				.build();
		
//		List<Designation> designationList = designationRepository.By; 
		Designation designation = designationRepository.findByDesignationName(desig)
		        .orElseThrow(() -> new IllegalArgumentException("Designation '" + desig + "' does not exist."));
		Department department = departmentRepository.findByDepartmentName(depart)
				.orElseThrow(() -> new IllegalArgumentException("Department '" + depart + "' does not exist."));
		
    	Employee employee = Employee.builder()
    			.name(name)
    			.designation(designation)
    			.department(department)
    			.dateOfJoining(this.getLocalDate(localdate))
    			.build();
    	
    	employeeRepository.save(employee);
    	return employee ;
    }
	public String saveEmployee() {
		
//		Designation designation = Designation.builder()
//				.designationName("CTO")
//				.build();
//		Department department = Department.builder()
//				.department("HR")
//				.build();
//		departmentRepository.save(department);
//		designationRepository.save(designation);
//		
//		Employee employee = Employee.builder()
//				.name("Luci")
//				.designation(designation)
//    			.department(department)
//				.dateOfJoining(LocalDate.now())
//				.build();
//		employeeRepository.save(employee);
//		return employee.toString() ;
		return "";
	}
}
