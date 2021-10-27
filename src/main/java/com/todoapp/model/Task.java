package com.todoapp.model;

import java.sql.Timestamp;

public class Task {
    private String title;
    private Timestamp createdAt;
    private String description;

    public Task() {
    }

    public Task(String title, String description, Timestamp createdAt) {
        this.title = title;
        this.createdAt = createdAt;
        this.description = description;
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
