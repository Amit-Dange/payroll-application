package com.epam.payroll_management.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.payroll_management.entity.Designation;
import com.epam.payroll_management.entity.Employee;
import com.epam.payroll_management.service.CreateEmployee;
import com.epam.payroll_management.service.DatabaseSummary;
import com.epam.payroll_management.service.DeleteEmployee;
import com.epam.payroll_management.service.UpdateEmployee;

import lombok.Data;

@RestController
public class PayrollController {
	
	private CreateEmployee createEmployee ;
	private DeleteEmployee deleteEmployee ;
	private DatabaseSummary databaseSummary ;
	private UpdateEmployee updateEmployee ;

	@Autowired
	public PayrollController(
			CreateEmployee createEmployee,
			DeleteEmployee deleteEmployee, 
			DatabaseSummary databaseSummary ,
			UpdateEmployee updateEmployee
			) 
	{
		this.createEmployee = createEmployee;
		this.deleteEmployee = deleteEmployee;
		this.updateEmployee = updateEmployee;
		this.databaseSummary = databaseSummary ;
	}

//
	@Data
	static class EmployeeRequest {
        public int empid;
        public String name;
        public String designation;
        public String department;
        public String dateOfJoining;
		@Override
		public String toString() {
			return "EmployeeRequest [empid=" + empid + ", name=" + name + ", designation=" + designation
					+ ", department=" + department + ", dateOfJoining=" + dateOfJoining + "]";
		}
        
    }
	
	
	@GetMapping("/designation")
	public List<Designation> getDesignationDatabase() {
		return databaseSummary.getAllDesignations();
	}
	
	
	@PostMapping("/create")
	public String createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		
		Employee emp = createEmployee.addEmployee(
                employeeRequest.getName(), 
                employeeRequest.getDesignation(), 
                employeeRequest.getDepartment(),
                employeeRequest.getDateOfJoining()
        );
		return "Employee created !! " + emp;
	}
	
	@GetMapping("/save")
	public String saveEmployee() {
		return createEmployee.saveEmployee();
	}
	
	
	@GetMapping("/read/{empid}")
    public String readEmployee(@PathVariable int empid) {
        return "input :";
    }
	
	@PutMapping("/update")
    public Employee updateEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return updateEmployee.updateEmployeeById(
                employeeRequest.empid, 
                employeeRequest.designation, 
                employeeRequest.department
        );
    }
	
	@DeleteMapping("/delete/{empid}")
    public void deleteEmployee(@PathVariable int empid) {
        deleteEmployee.deleteEmployeeById(empid);
    }
	
}
