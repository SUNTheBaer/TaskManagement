package com.taskmanagement.taskmanagement.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.taskmanagement.taskmanagement.Models.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{
    @Query("SELECT title, status FROM task")
    List<Task> getTaskSummary();
}
