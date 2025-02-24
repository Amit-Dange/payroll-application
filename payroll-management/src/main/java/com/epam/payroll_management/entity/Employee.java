package com.epam.payroll_management.entity;

import java.time.LocalDate;

import com.epam.payroll_management.utility.ValidationsUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public @Builder
class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
    private String name;
    @ManyToOne
    @JoinColumn(name = "designation_id")
    private Designation designation;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private LocalDate dateOfJoining ;
    private double salary;  

    public void setEmpId(int empId) {
        ValidationsUtils.validateValue(empId);
        this.empId = empId;
    }

    public void setName(String name) {
        ValidationsUtils.validateString(name);
        this.name = name;
    }

    public void setDesignation(Designation designation) {
        ValidationsUtils.validateObject(designation);
        this.designation = designation;
    }

    public void setDepartment(Department department) {
        ValidationsUtils.validateObject(department);
        this.department = department;
    }
    public void setDateOfJoining(LocalDate dateOfJoining) {
    	ValidationsUtils.validateObject(dateOfJoining);
    	this.dateOfJoining = dateOfJoining;
    }    
    
    public void setSalary() {
    	this.salary = department.getBonus() + designation.getSalary() ;
    }
    
    

    @Override
    public String toString() {
        return String.format(
            "Employee Details:\n" +
            "-----------------\n" +
            "ID           : %d\n" +
            "Name         : %s\n" +
            "Designation  : %s\n" +
            "Department   : %s\n" +
            "Date Joined  : %s\n" +
            "Salary        : %s\n",
            empId, name, designation, department, dateOfJoining, designation.getSalary()
        );
    }

}
