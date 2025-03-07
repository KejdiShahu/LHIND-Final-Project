package com.lhind.jobportal.service;

import com.lhind.jobportal.mapper.JobSeekerMapper;
import com.lhind.jobportal.model.dto.JobSeekerDTO;
import com.lhind.jobportal.model.entity.JobSeeker;
import com.lhind.jobportal.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;

    public JobSeekerService(@Autowired JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public Page<JobSeekerDTO> getAllJobSeekers(int page, int size) {
        Page<JobSeeker> jobSeekers = jobSeekerRepository.findAll(PageRequest.of(page, size));
        return jobSeekers.map(JobSeekerMapper::toDTO);
    }

    public JobSeekerDTO getJobSeekerById(Long id) {
        return JobSeekerMapper.toDTO(jobSeekerRepository.findById(id).orElse(null));
    }

    public boolean existsById(Long id) {
        return jobSeekerRepository.existsById(id);
    }

}
