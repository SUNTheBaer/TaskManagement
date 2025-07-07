package com.taskmanagement.taskmanagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.taskmanagement.Models.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
