package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.ApplicationCreateDTO;
import com.lhind.jobportal.model.dto.ApplicationDTO;
import com.lhind.jobportal.model.dto.JobDTO;
import com.lhind.jobportal.model.dto.JobSeekerDTO;
import com.lhind.jobportal.model.entity.Application;
import com.lhind.jobportal.model.entity.Job;
import com.lhind.jobportal.model.entity.JobSeeker;

public class ApplicationMapper {

    public static ApplicationDTO toDTO(Application application) {
        if (application == null) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setId(application.getId());

        JobDTO jobDTO = JobMapper.toDTO(application.getJob());
        applicationDTO.setJob(jobDTO);

        JobSeekerDTO jobSeekerDTO = JobSeekerMapper.toDTO(application.getJobSeeker());
        applicationDTO.setJobSeeker(jobSeekerDTO);

        applicationDTO.setStatus(application.getStatus());
        applicationDTO.setCoverLetter(application.getCoverLetter());
        applicationDTO.setResumeUrl(application.getResumeUrl());
        applicationDTO.setCreatedAt(application.getCreatedAt());
        applicationDTO.setUpdatedAt(application.getUpdatedAt());
        applicationDTO.setEmployerNotes(application.getEmployerNotes());

        return applicationDTO;
    }

    public static Application toEntity(ApplicationCreateDTO applicationCreateDTO, JobDTO job, JobSeekerDTO jobSeeker) {
        if (applicationCreateDTO == null) {
            return null;
        }

        Application application = new Application();
        application.setJob(JobMapper.toEntity(job));
        application.setJobSeeker(JobSeekerMapper.toEntity(jobSeeker));
        application.setCoverLetter(applicationCreateDTO.getCoverLetter());
        application.setResumeUrl(applicationCreateDTO.getResumeUrl());

        return application;
    }

    public static Application toEntity(ApplicationDTO applicationDTO, JobDTO job, JobSeekerDTO jobSeeker) {
        if (applicationDTO == null) {
            return null;
        }

        Application application = new Application();
        application.setId(applicationDTO.getId());
        application.setJob(JobMapper.toEntity(job));
        application.setJobSeeker(JobSeekerMapper.toEntity(jobSeeker));
        application.setStatus(applicationDTO.getStatus());
        application.setCoverLetter(applicationDTO.getCoverLetter());
        application.setResumeUrl(applicationDTO.getResumeUrl());
        application.setCreatedAt(applicationDTO.getCreatedAt());
        application.setUpdatedAt(applicationDTO.getUpdatedAt());
        application.setEmployerNotes(applicationDTO.getEmployerNotes());

        return application;
    }
}