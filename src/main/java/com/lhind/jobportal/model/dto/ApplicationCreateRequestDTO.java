package com.lhind.jobportal.model.dto;

public class ApplicationCreateRequestDTO {
    private ApplicationCreateDTO application;
    private Long jobSeekerId;

    public ApplicationCreateDTO getApplication() {
        return application;
    }

    public void setApplication(ApplicationCreateDTO application) {
        this.application = application;
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }
}
