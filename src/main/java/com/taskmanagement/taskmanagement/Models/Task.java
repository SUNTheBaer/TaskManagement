package com.taskmanagement.taskmanagement.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity(name = "Task")
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "title", nullable = false, columnDefinition = "TEXT", unique = true)
    private String title;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

    @Column(name = "due_date", nullable = false, columnDefinition = "TEXT")
    private String due_date;

    @Column(name = "priority", nullable = false, columnDefinition = "TEXT")
    private priority priority;

    @Column(name = "status", nullable = false, columnDefinition = "TEXT")
    private status status;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    enum priority {
        LOW, MEDIUM, HIGH
    }

    enum status {
        TO_DO, IN_PROGRESS, COMPLETED
    }
}
