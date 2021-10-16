package com.emp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emp.model.Task;

public interface TaskDao extends JpaRepository<Task, Integer> {

}
