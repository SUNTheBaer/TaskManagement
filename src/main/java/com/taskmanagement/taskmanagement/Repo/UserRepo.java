package com.taskmanagement.taskmanagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskmanagement.taskmanagement.Models.User;

public interface UserRepo extends JpaRepository<User, Long>{
}
