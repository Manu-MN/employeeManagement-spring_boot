package com.emp.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.model.EmployeeDetails;
import com.emp.responseModel.EmpResponseModel;
import com.emp.service.EmpService;

@RestController()
@RequestMapping("rest-api")
public class EmployeeCtr {

	@Autowired
	EmpService empService;
	
	@PostMapping("/saveEmployee")
	public EmpResponseModel save(@Validated @RequestBody EmployeeDetails employeeDetails) {
		if(empService.save(employeeDetails)) {
			return new EmpResponseModel(new Date(),HttpStatus.CREATED, "Record saved successfully", employeeDetails.getEmpId());
		}
		return new EmpResponseModel(new Date(),HttpStatus.BAD_REQUEST, "Failed", employeeDetails.getEmpId());
	}
	
	@GetMapping("/getEmployees")
	public List<EmployeeDetails> getEmployees(){
		return empService.employees();
	}
	
	@PutMapping("/updateEmployee")
	public EmpResponseModel update(@RequestBody EmployeeDetails employeeDetails) {
		if(empService.update(employeeDetails)) {
			return new EmpResponseModel(new Date(),HttpStatus.OK, "Record updated successfully", employeeDetails.getEmpId());
		}
		return new EmpResponseModel(new Date(),HttpStatus.BAD_REQUEST, "update failed", employeeDetails.getEmpId());
	}
	
	@DeleteMapping("/deleteEmployee/{id}")
	public EmpResponseModel delete(@PathVariable("id") int id ) {
		if(empService.delete(id)) {
			return new EmpResponseModel(new Date(),HttpStatus.OK, "Record deleted successfully", id);
		}
		return new EmpResponseModel(new Date(),HttpStatus.BAD_REQUEST, "delete failed ", id);
	}
}
