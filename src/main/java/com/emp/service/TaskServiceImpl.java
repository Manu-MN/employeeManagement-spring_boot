package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmpDetailsDao;
import com.emp.dao.TaskDao;
import com.emp.model.EmployeeDetails;
import com.emp.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao taskDao;
	
	@Autowired
	EmpDetailsDao empDetailsDao;

	@Override
	public boolean save(Task task) {
		try {
			Optional<EmployeeDetails> emp = empDetailsDao.findById(task.getEmployee().getEmpId());
			if(!emp.isPresent()) {
				return false;
			}
			taskDao.save(task);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<Task> tasks() {
		try {
			return taskDao.findAll();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Task task) {
		try {
			Optional<Task> t = taskDao.findById(task.getTaskId());
			if(t.get() != null) {
				taskDao.save(task);
				return true;
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
			taskDao.deleteById(id);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
