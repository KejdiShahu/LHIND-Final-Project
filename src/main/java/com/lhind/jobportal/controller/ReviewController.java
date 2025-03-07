package com.lhind.jobportal.controller;

import com.lhind.jobportal.model.dto.ReviewCreateDTO;
import com.lhind.jobportal.model.dto.ReviewCreateRequestDTO;
import com.lhind.jobportal.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
