package com.epam.payroll_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.payroll_management.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee , Integer>{

}
