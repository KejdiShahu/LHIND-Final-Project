package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.EmployerDTO;
import com.lhind.jobportal.model.dto.JobCreateDTO;
import com.lhind.jobportal.model.dto.JobDTO;
import com.lhind.jobportal.model.entity.Employer;
import com.lhind.jobportal.model.entity.Job;

public class JobMapper {

    public static JobDTO toDTO(Job job) {
        if (job == null) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setSalary(job.getSalary());
        jobDTO.setJobType(job.getJobType());
        jobDTO.setExperienceRequired(job.getExperienceRequired());
        jobDTO.setSkillsRequired(job.getSkillsRequired());
        jobDTO.setCreatedAt(job.getCreatedAt());
        jobDTO.setUpdatedAt(job.getUpdatedAt());
        jobDTO.setActive(job.isActive());

        if (job.getEmployer() != null) {
            EmployerDTO employerDTO = EmployerMapper.toDTO(job.getEmployer());
            jobDTO.setEmployer(employerDTO);
        }

        return jobDTO;
    }

    public static Job toEntity(JobDTO jobDTO) {
        if (jobDTO == null) {
            return null;
        }

        Job job = new Job();
        job.setId(jobDTO.getId());
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setLocation(jobDTO.getLocation());
        job.setSalary(jobDTO.getSalary());
        job.setJobType(jobDTO.getJobType());
        job.setExperienceRequired(jobDTO.getExperienceRequired());
        job.setSkillsRequired(jobDTO.getSkillsRequired());
        job.setCreatedAt(jobDTO.getCreatedAt());
        job.setUpdatedAt(jobDTO.getUpdatedAt());
        job.setActive(jobDTO.isActive());

        if (jobDTO.getEmployer() != null) {
            Employer employer = EmployerMapper.toEntity(jobDTO.getEmployer());
            job.setEmployer(employer);
        }

        return job;
    }

    public static Job toEntity(JobCreateDTO jobCreateDTO, EmployerDTO employer) {
        if (jobCreateDTO == null) {
            return null;
        }

        Job job = new Job();
        job.setTitle(jobCreateDTO.getTitle());
        job.setDescription(jobCreateDTO.getDescription());
        job.setLocation(jobCreateDTO.getLocation());
        job.setSalary(jobCreateDTO.getSalary());
        job.setJobType(jobCreateDTO.getJobType());
        job.setExperienceRequired(jobCreateDTO.getExperienceRequired());
        job.setSkillsRequired(jobCreateDTO.getSkillsRequired());
        job.setEmployer(EmployerMapper.toEntity(employer));

        return job;
    }
}