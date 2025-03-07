package com.lhind.jobportal.service;

import com.lhind.jobportal.mapper.ApplicationMapper;
import com.lhind.jobportal.model.dto.ApplicationCreateDTO;
import com.lhind.jobportal.model.dto.ApplicationDTO;
import com.lhind.jobportal.model.entity.Application;
import com.lhind.jobportal.repository.ApplicationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobService jobService;
    private final JobSeekerService jobSeekerService;

    public ApplicationService(ApplicationRepository applicationRepository, JobService jobService, JobSeekerService jobSeekerService) {
        this.applicationRepository = applicationRepository;
        this.jobService = jobService;
        this.jobSeekerService = jobSeekerService;
    }

    public Page<ApplicationDTO> getAllApplicationsByJobIdAndStatus(Long jobId, String status, int page, int size) {
        Page<Application> applications = applicationRepository.findAllByJob_IdAndAndStatus(jobId, status, PageRequest.of(page, size));
        return applications.map(ApplicationMapper::toDTO);
    }

    public boolean updateApplicationStatus(Long applicationId, String status) {
        if (applicationRepository.existsById(applicationId)) {
            applicationRepository.updateStatus(applicationId, status);
            return true;
        }
        return false;
    }

    public boolean createApplication(ApplicationCreateDTO application, Long jobId, Long jobSeekerId) {
        if (jobService.existsById(jobId) && jobSeekerService.existsById(jobSeekerId)) {
            applicationRepository.save(ApplicationMapper.toEntity(application, jobService.getJobById(jobId), jobSeekerService.getJobSeekerById(jobSeekerId)));
            return true;
        }
        return false;
    }
}
