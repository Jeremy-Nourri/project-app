package org.example.serverappproject.domain.model;

import java.time.LocalDate;
import java.util.List;

public class Task {
    private Long id;
    private String title;
    private String detail;
    private TaskStatusEnum taskStatus;
    private LocalDate dueDate;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private List<Tag> tags;

    public Task(String title, String detail, TaskStatusEnum taskStatus, LocalDate dueDate, LocalDate createdAt) {
        this.title = title;
        this.detail = detail;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }

    public Task(Long id, String title, String detail, TaskStatusEnum taskStatus, LocalDate dueDate, LocalDate createdAt, LocalDate updatedAt, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.detail = detail;
        this.taskStatus = taskStatus;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public TaskStatusEnum getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
