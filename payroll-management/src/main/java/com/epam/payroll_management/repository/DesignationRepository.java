package com.epam.payroll_management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epam.payroll_management.entity.Designation;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, Integer> {
	Optional<Designation> findByDesignationName(String designation_name);

}
