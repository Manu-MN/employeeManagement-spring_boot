package com.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private EmployeeDetails empId;
	
	public Task() {
		super();
	}
	
	public Task(int taskId, String taskAssigned, String estimatedTime, EmployeeDetails empId) {
		super();
		this.taskId = taskId;
		this.taskAssigned = taskAssigned;
		this.estimatedTime = estimatedTime;
		this.empId = empId;
	}

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

	public EmployeeDetails getEmpId() {
		return empId;
	}

	public void setEmpId(EmployeeDetails empId) {
		this.empId = empId;
	}
	
}
