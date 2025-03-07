package com.lhind.jobportal.model.dto;

public class JobCreateRequestDTO {
    private JobCreateDTO job;
    private Long employerId;

    public JobCreateDTO getJob() {
        return job;
    }

    public void setJob(JobCreateDTO job) {
        this.job = job;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }
}