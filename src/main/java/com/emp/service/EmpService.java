package com.emp.service;

import java.util.List;

import com.emp.model.EmployeeDetails;

public interface EmpService {

	boolean save(EmployeeDetails employeeDetails);
	List<EmployeeDetails> employees();
	boolean update(EmployeeDetails employeeDetails);
	boolean delete(int id);
}
