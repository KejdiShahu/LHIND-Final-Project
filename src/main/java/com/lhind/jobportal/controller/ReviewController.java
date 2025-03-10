package com.lhind.jobportal.controller;

import com.lhind.jobportal.model.dto.ReviewCreateRequestDTO;
import com.lhind.jobportal.model.dto.ReviewDTO;
import com.lhind.jobportal.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Void> addReview(@RequestBody ReviewCreateRequestDTO review) {
        if (reviewService.addReview(review.getReview(), review.getEmployerId(), review.getReview().getJobId())) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<Page<ReviewDTO>> getAllReviews(
            @RequestParam Long jobId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(reviewService.getAllReviewsByJob(jobId, PageRequest.of(page, size)));
    }

    @GetMapping(path = "/rating/{rating}")
    public ResponseEntity<Page<ReviewDTO>> getAllReviewsByRating(
            @RequestParam Long jobId,
            @PathVariable int rating,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(
                reviewService.getAllReviewsByRatingAndJob(rating, jobId, PageRequest.of(page, size))
        );
    }

}
