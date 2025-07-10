package com.taskmanagement.taskmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.taskmanagement.Models.Task;
import com.taskmanagement.taskmanagement.Models.User;
import com.taskmanagement.taskmanagement.Repo.TaskRepo;
import com.taskmanagement.taskmanagement.Repo.UserRepo;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TaskRepo taskRepo;
    
    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value ="/user")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public User getUserWithId(@PathVariable("id") long id) {
        return userRepo.findById(id).get();
    }

    @PostMapping(value = "/user")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value = "/user/{id}")
    public String updateUser(@PathVariable("id") long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setEmail(user.getEmail());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(user.getPassword());
        userRepo.save(updatedUser);
        return "Updated...";
    }

    @DeleteMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with id: " + id;
    }

    @GetMapping(value ="/task")
    public List<Task> getTask() {
        return taskRepo.findAll();
    }

    @GetMapping(value = "/task/{id}")
    public Task getTaskWithId(@PathVariable("id") long id) {
        return taskRepo.findById(id).get();
    }

    @PostMapping(value = "/task")
    public String saveTask(@RequestBody Task task) {
        taskRepo.save(task);
        return "Saved...";
    }

    @PutMapping(value = "/task/{id}")
    public String updateTask(@PathVariable("id") long id, @RequestBody Task task) {
        Task updatedTask = taskRepo.findById(id).get();
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDue_date(task.getDue_date());
        updatedTask.setPriority(task.getPriority());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setUser(task.getUser());
        taskRepo.save(updatedTask);
        return "Updated...";
    }

    @DeleteMapping(value = "/task/{id}")
    public String deleteTask(@PathVariable("id") long id) {
        Task deleteTask = taskRepo.findById(id).get();
        taskRepo.delete(deleteTask);
        return "Deleted task with id: " + id;
    }

    @PostMapping (value = "/user/login")
    public String userLogin() {
        return "";
    }

    @GetMapping (value = "/task/report")
    public List<Task> taskSummary() {
        return taskRepo.getTaskSummary();
    }

    @PutMapping (value = "task/{taskId}/assign/{userId}")
    public String assignTask (@PathVariable("taskId") long taskId, @PathVariable("userId") long userId) {
        return "";
    }
}
