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

import com.emp.model.Task;
import com.emp.responseModel.EmpResponseModel;
import com.emp.service.TaskService;

@RestController()
@RequestMapping("rest-api")
public class TaskCtr {
	
	@Autowired
	TaskService taskService;
	
	@PostMapping("/addTask")
	public EmpResponseModel save(@Validated @RequestBody Task task) {
		if(taskService.save(task)) {
			return new EmpResponseModel(new Date(),HttpStatus.CREATED, "Record saved successfully", task.getTaskId());
		}
		return new EmpResponseModel(new Date(),HttpStatus.BAD_REQUEST, "Failed", task.getTaskId());
	}
	
	@GetMapping("/getTasks")
	public List<Task> displayTasks(){
		return taskService.tasks();
	}
	
	@PutMapping("/updateTask")
	public EmpResponseModel updateTask(@RequestBody Task task) {
		if(taskService.update(task)) {
			return new EmpResponseModel(new Date(),HttpStatus.OK, "Record updated successfully", task.getTaskId());
		}
		return new EmpResponseModel(new Date(),HttpStatus.BAD_REQUEST, "update failed", task.getTaskId());
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public EmpResponseModel deleteTask(@PathVariable("id") int id ) {
		if(taskService.delete(id)) {
			return new EmpResponseModel(new Date(),HttpStatus.OK, "Record deleted successfully", id);
		}
		return new EmpResponseModel(new Date(),HttpStatus.BAD_REQUEST, "delete failed ", id);
	}
	
}
