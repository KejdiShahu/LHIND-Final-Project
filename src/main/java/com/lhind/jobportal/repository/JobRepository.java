package com.lhind.jobportal.repository;

import com.lhind.jobportal.model.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findAllByEmployer_UserId(Long employerId, Pageable pageable);

    Page<Job> findAllByTitle(String title, Pageable pageable);

    Page<Job> findAllByLocation(String location, Pageable pageable);
}
