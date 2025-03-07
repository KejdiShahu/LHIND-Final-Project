package com.lhind.jobportal.controller;

import com.lhind.jobportal.model.dto.ApplicationCreateDTO;
import com.lhind.jobportal.model.dto.ApplicationCreateRequestDTO;
import com.lhind.jobportal.model.dto.ApplicationDTO;
import com.lhind.jobportal.service.ApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/applications")
public class ApplicationController {
    private ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<Page<ApplicationDTO>> getAllApplicationsByJobIdAndStatus(
            @RequestParam Long jobId,
            @RequestParam String status,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(applicationService.getAllApplicationsByJobIdAndStatus(jobId, status, page, size));
    }

    @PatchMapping(path = "/{applicationId}")
    public ResponseEntity<Void> updateApplicationStatus(
            @PathVariable Long applicationId,
            @RequestParam String status) {
        if (applicationService.updateApplicationStatus(applicationId, status))
            return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Void> createApplication(@RequestBody ApplicationCreateRequestDTO application) {
        if (applicationService.createApplication(application.getApplication(), application.getApplication().getJobId(), application.getJobSeekerId()))
            return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

}
