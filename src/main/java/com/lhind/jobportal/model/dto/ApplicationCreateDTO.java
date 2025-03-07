package com.lhind.jobportal.model.dto;

import jakarta.validation.constraints.NotNull;

public class ApplicationCreateDTO {
    @NotNull(message = "Job ID is required")
    private Long jobId;

    private String coverLetter;
    private String resumeUrl;

    public ApplicationCreateDTO() {
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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
}