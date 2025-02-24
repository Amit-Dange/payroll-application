package com.epam.payroll_management.presentation;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.epam.payroll_management.entity.Department;
import com.epam.payroll_management.entity.Designation;
import com.epam.payroll_management.service.DepartmentService;
import com.epam.payroll_management.service.DesignationService;

@RestController
public class AdminController {
	
	DepartmentService departmentService ;
	DesignationService designationService ;
	
	public AdminController(DepartmentService departmentService, DesignationService designationService) {
		this.departmentService = departmentService;
		this.designationService = designationService;
	}

	@PostMapping("/admin/addDepartment")
	public Department addNewDepartment(@RequestBody Department department) {
	    return departmentService.addDepartment(department.getDepartmentName(), department.getBonus());
	}
	
	@DeleteMapping("/admin/deleteDepartment")
	public Department deleteOldDepartment(@RequestBody Map<String, Integer> request) {
		int departmentId = request.get("departmentId");
	    return departmentService.deleteDepartment(departmentId);
	}
	
	@PostMapping("/admin/addDesignation")
	public Designation addNewDesignation(@RequestParam String designationName ,@RequestParam double salary) {
		return designationService.addDesignation(designationName, salary);
	}
	
	@DeleteMapping("/admin/deleteDesingation")
	public Designation deleteOldDesignation(@RequestParam int designationId) {
		return designationService.deleteDesignation(designationId);
	}
	
	
}
