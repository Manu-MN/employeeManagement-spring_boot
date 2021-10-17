package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(generator = "increment")
	private int taskId;
	@Column(nullable = false)
	private String taskAssigned;
	@Column(nullable = false)
	private String estimatedTime;
	
	@ManyToOne()
	@JoinColumn(name = "empId",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EmployeeDetails employee;
	
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskAssigned() {
		return taskAssigned;
	}

	public void setTaskAssigned(String taskAssigned) {
		this.taskAssigned = taskAssigned;
	}

	public String getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public EmployeeDetails getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDetails employee) {
		this.employee = employee;
	}

}
