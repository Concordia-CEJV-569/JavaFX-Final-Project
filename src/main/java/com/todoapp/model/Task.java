package com.todoapp.model;

import java.sql.Timestamp;

public class Task {
    private int id;
    private int userId;
    private String title;
    private Timestamp createdAt;
    private String description;

    public Task() {
    }

    public Task(int userId, String title, String description, Timestamp createdAt) {
        this.title = title;
        this.userId = userId;
        this.createdAt = createdAt;
        this.description = description;
    }

    public Task(int id, int userId, String title, String description, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.userId = userId;
        this.createdAt = createdAt;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
