package com.lhind.jobportal.model.dto;

import java.time.LocalDateTime;

public class ApplicationDTO {
    private Long id;
    private JobDTO job;
    private JobSeekerDTO jobSeeker;
    private String status;
    private String coverLetter;
    private String resumeUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String employerNotes;

    public ApplicationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobDTO getJob() {
        return job;
    }

    public void setJob(JobDTO job) {
        this.job = job;
    }

    public JobSeekerDTO getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeekerDTO jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmployerNotes() {
        return employerNotes;
    }

    public void setEmployerNotes(String employerNotes) {
        this.employerNotes = employerNotes;
    }
}