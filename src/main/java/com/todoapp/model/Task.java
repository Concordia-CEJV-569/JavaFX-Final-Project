package com.todoapp.model;

public class Task {
    private String title;
    private long CreatedAt;
    private String description;

    public Task() {
    }

    public Task(String title, long createdAt, String description) {
        this.title = title;
        CreatedAt = createdAt;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(long createdAt) {
        CreatedAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
