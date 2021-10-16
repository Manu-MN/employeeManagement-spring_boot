package com.emp.responseModel;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class EmpResponseModel {

	private Date timeStamp;
	private HttpStatus status;
	private String message;
	private int id;
	
	public EmpResponseModel() {
		super();// TODO Auto-generated constructor stub
	}
	
	public EmpResponseModel(Date timeStamp, HttpStatus status, String message, int id) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.message = message;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
