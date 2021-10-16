package com.emp.service;

import java.util.List;

import com.emp.model.Task;

public interface TaskService {

	boolean save(Task task);
	List<Task> tasks();
	boolean update(Task task);
	boolean delete(int id);
	
}
