package com.lhind.jobportal.service;

import com.lhind.jobportal.mapper.JobMapper;
import com.lhind.jobportal.mapper.ReviewMapper;
import com.lhind.jobportal.model.dto.ReviewCreateDTO;
import com.lhind.jobportal.model.dto.ReviewDTO;
import com.lhind.jobportal.model.entity.Review;
import com.lhind.jobportal.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final EmployerService employerService;
    private final JobService jobService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, EmployerService employerService, JobService jobService) {
        this.reviewRepository = reviewRepository;
        this.employerService = employerService;
        this.jobService = jobService;
    }

    public boolean addReview(ReviewCreateDTO review, Long employerId, Long jobId) {
        if (employerService.existsById(employerId) && jobService.existsById(jobId)) {
            reviewRepository.save(ReviewMapper.toEntity(review, jobService.getJobById(jobId), employerService.getEmployerById(employerId)));
            return true;
        }
        return false;
    }

    public Page<ReviewDTO> getAllReviewsByRatingAndJob(int rating, Long jobId, Pageable pageable) {
        return reviewRepository.findAllByRatingAndJob(
                rating,
                JobMapper.toEntity(jobService.getJobById(jobId)),
                pageable
                )
                .map(ReviewMapper::toDTO);
    }

    public Page<ReviewDTO> getAllReviewsByJob(Long jobId, Pageable pageable) {
        return reviewRepository.findAllByJob(
                JobMapper.toEntity(jobService.getJobById(jobId)),
                pageable
        ).map(ReviewMapper::toDTO);
    }
}
