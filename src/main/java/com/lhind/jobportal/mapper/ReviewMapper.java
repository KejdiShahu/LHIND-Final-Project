package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.EmployerDTO;
import com.lhind.jobportal.model.dto.JobDTO;
import com.lhind.jobportal.model.dto.ReviewCreateDTO;
import com.lhind.jobportal.model.dto.ReviewDTO;
import com.lhind.jobportal.model.entity.Review;
import com.lhind.jobportal.model.entity.Job;
import com.lhind.jobportal.model.entity.Employer;

public class ReviewMapper {

    public static ReviewDTO toDTO(Review review) {
        if (review == null) {
            return null;
        }

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setJob(JobMapper.toDTO(review.getJob()));
        reviewDTO.setEmployer(EmployerMapper.toDTO(review.getEmployer()));
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setCreatedAt(review.getCreatedAt());
        reviewDTO.setUpdatedAt(review.getUpdatedAt());

        return reviewDTO;
    }

    public static Review toEntity(ReviewCreateDTO reviewCreateDTO, JobDTO jobDTO, EmployerDTO employerDTO) {
        if (reviewCreateDTO == null) {
            return null;
        }

        Review review = new Review();
        review.setJob(JobMapper.toEntity(jobDTO));
        review.setEmployer(EmployerMapper.toEntity(employerDTO));
        review.setRating(reviewCreateDTO.getRating());
        review.setComment(reviewCreateDTO.getComment());

        return review;
    }

    public static Review toEntity(ReviewDTO reviewDTO, JobDTO jobDTO, EmployerDTO employerDTO) {
        if (reviewDTO == null) {
            return null;
        }

        Review review = new Review();
        review.setId(reviewDTO.getId());
        review.setJob(JobMapper.toEntity(jobDTO));
        review.setEmployer(EmployerMapper.toEntity(employerDTO));
        review.setRating(reviewDTO.getRating());
        review.setComment(reviewDTO.getComment());
        review.setCreatedAt(reviewDTO.getCreatedAt());
        review.setUpdatedAt(reviewDTO.getUpdatedAt());

        return review;
    }
}