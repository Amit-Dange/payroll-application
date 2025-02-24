package com.epam.payroll_management.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.epam.payroll_management.entity.Designation;
import com.epam.payroll_management.repository.DesignationRepository;

@Service
public class DesignationService {
	
	DesignationRepository designationRepository;
	
	public DesignationService(DesignationRepository designationRepository ) {
		 this.designationRepository = designationRepository ; 
	}
	
	public Designation addDesignation(String designationName , double salary) {
		Designation designation = Designation.builder()
				.designationName(designationName)
				.salary(salary)
				.build();
		return designationRepository.save(designation);
	}
	
	public Designation deleteDesignation(int id) {
		Optional<Designation> designation = designationRepository.findById(id);
		if(designation.isEmpty()) {
			throw new IllegalArgumentException("Designation Does not Exist");
		}
		designationRepository.deleteById(id);
		return designation.get() ;
	}
}
