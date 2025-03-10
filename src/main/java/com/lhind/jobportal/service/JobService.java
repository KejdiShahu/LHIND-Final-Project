package com.lhind.jobportal.service;

import com.lhind.jobportal.mapper.JobMapper;
import com.lhind.jobportal.model.dto.JobCreateDTO;
import com.lhind.jobportal.model.dto.JobDTO;
import com.lhind.jobportal.model.entity.Job;
import com.lhind.jobportal.repository.JobRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;
    private final EmployerService employerService;

    @Autowired
    public JobService(JobRepository jobRepository, EmployerService employerService) {
        this.jobRepository = jobRepository;
        this.employerService = employerService;
    }

    @Transactional
    public boolean save(JobCreateDTO job, Long employerId) {
        if (employerService.existsById(employerId)) {
            jobRepository.save(JobMapper.toEntity(job, employerService.getEmployerById(employerId)));
            return true;
        }
        return false;
    }

    public Page<JobDTO> getAllJobsByEmployerID(Long employerId, int page, int size) {
        Page<Job> jobs = jobRepository.findAllByEmployer_UserId(employerId, PageRequest.of(page, size));
        return jobs.map(JobMapper::toDTO);
    }

    public Page<JobDTO> getAllJobsByTitle(String title, int page, int size) {
        Page<Job> jobs = jobRepository.findAllByTitle(title, PageRequest.of(page, size));
        return jobs.map(JobMapper::toDTO);
    }

    public Page<JobDTO> getAllJobsByLocation(String location, int page, int size) {
        Page<Job> jobs = jobRepository.findAllByLocation(location, PageRequest.of(page, size));
        return jobs.map(JobMapper::toDTO);
    }

    public JobDTO getJobById(Long id) {
        return JobMapper.toDTO(jobRepository.findById(id).orElse(null));
    }

    public boolean existsById(Long id) {
        return jobRepository.existsById(id);
    }

    public Page<JobDTO> getAllJobs(Pageable pageable) {
        return jobRepository.findAll(pageable).map(JobMapper::toDTO);
    }
}
