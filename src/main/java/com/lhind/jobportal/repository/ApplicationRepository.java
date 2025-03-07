package com.lhind.jobportal.repository;

import com.lhind.jobportal.model.entity.Application;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    Page<Application> findAllByJob_IdAndAndStatus(Long jobId, String Status, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE Application a SET a.status = :status WHERE a.id = :id")
    void updateStatus(@Param("id") Long id, @Param("status") String status);

}
