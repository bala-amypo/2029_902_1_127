package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintResponse {
    private Long id;
    private String title;
    private String category;
    private Complaint.Status status;
    private Integer priorityScore;
    private boolean success;
    private String message;

    public ComplaintResponse(Long id, String title, String category, Complaint.Status status, Integer priorityScore) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.status = status;
        this.priorityScore = priorityScore;
        this.success = true;
    }

    public ComplaintResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Complaint.Status getStatus() { return status; }
    public void setStatus(Complaint.Status status) { this.status = status; }

    public Integer getPriorityScore() { return priorityScore; }
    public void setPriorityScore(Integer priorityScore) { this.priorityScore = priorityScore; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}