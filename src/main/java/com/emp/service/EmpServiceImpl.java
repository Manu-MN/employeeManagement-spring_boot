package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmpDetailsDao;
import com.emp.model.EmployeeDetails;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpDetailsDao empDetailsDao;
	
	@Override
	public boolean save(EmployeeDetails employeeDetails) {
		
		try {
			if(empDetailsDao.save(employeeDetails) != null) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public List<EmployeeDetails> employees() {
		
		return empDetailsDao.findAll();
	}

	@Override
	public boolean update(EmployeeDetails employeeDetails) {
		try {
			Optional<EmployeeDetails> details = empDetailsDao.findById(employeeDetails.getEmpId());
			if(details.get() != null) {
				if(empDetailsDao.save(employeeDetails) != null) {
					return true;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		try {
			empDetailsDao.deleteById(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
