package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.JobSeekerDTO;
import com.lhind.jobportal.model.entity.JobSeeker;

public class JobSeekerMapper {

    public static JobSeekerDTO toDTO(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return null;
        }

        JobSeekerDTO jobSeekerDTO = new JobSeekerDTO();
        jobSeekerDTO.setUserId(jobSeeker.getUserId());
        jobSeekerDTO.setUserDetails(UserDetailsMapper.toDTO(jobSeeker.getUserDetails()));
        jobSeekerDTO.setPhoneNumber(jobSeeker.getPhoneNumber());
        jobSeekerDTO.setDateOfBirth(jobSeeker.getDateOfBirth());
        jobSeekerDTO.setResumeUrl(jobSeeker.getResumeUrl());
        jobSeekerDTO.setSkills(jobSeeker.getSkills());
        jobSeekerDTO.setExperienceYears(jobSeeker.getExperienceYears());
        jobSeekerDTO.setEducation(jobSeeker.getEducation());

        return jobSeekerDTO;
    }

    public static JobSeeker toEntity(JobSeekerDTO jobSeekerDTO) {
        if (jobSeekerDTO == null) {
            return null;
        }

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setUserId(jobSeekerDTO.getUserId());
        jobSeeker.setUserDetails(UserDetailsMapper.toEntity(jobSeekerDTO.getUserDetails()));
        jobSeeker.setPhoneNumber(jobSeekerDTO.getPhoneNumber());
        jobSeeker.setDateOfBirth(jobSeekerDTO.getDateOfBirth());
        jobSeeker.setResumeUrl(jobSeekerDTO.getResumeUrl());
        jobSeeker.setSkills(jobSeekerDTO.getSkills());
        jobSeeker.setExperienceYears(jobSeekerDTO.getExperienceYears());
        jobSeeker.setEducation(jobSeekerDTO.getEducation());

        return jobSeeker;
    }
}