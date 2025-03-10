package com.lhind.jobportal.repository;

import com.lhind.jobportal.model.entity.Job;
import com.lhind.jobportal.model.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByRatingAndJob(int rating, Job job, Pageable pageable);

    Page<Review> findAllByJob(Job job, Pageable pageable);
}
