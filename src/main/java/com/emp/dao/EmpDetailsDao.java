package com.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emp.model.EmployeeDetails;

public interface EmpDetailsDao extends JpaRepository<EmployeeDetails, Integer> {
	
}
