package com.lhind.jobportal.model.dto;

public class ReviewCreateRequestDTO {
    private ReviewCreateDTO review;
    private Long employerId;

    public ReviewCreateDTO getReview() {
        return review;
    }

    public void setReview(ReviewCreateDTO review) {
        this.review = review;
    }

    public Long getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Long employerId) {
        this.employerId = employerId;
    }
}
