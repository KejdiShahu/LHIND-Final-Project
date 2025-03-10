package com.lhind.jobportal.controller;

import com.lhind.jobportal.model.dto.JobCreateRequestDTO;
import com.lhind.jobportal.model.dto.JobDTO;
import com.lhind.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public ResponseEntity<Void> save(
            @RequestBody JobCreateRequestDTO jobCreateRequestDTO) {
        if (jobService.save(jobCreateRequestDTO.getJob(), jobCreateRequestDTO.getEmployerId()))
            return ResponseEntity.ok().build();
        else return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/employer/{employerId}")
    public ResponseEntity<Page<JobDTO>> getAll(
            @PathVariable Long employerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(jobService.getAllJobsByEmployerID(employerId, page, size));
    }

    @GetMapping(path = "/title/{title}")
    public ResponseEntity<Page<JobDTO>> getAllByTitle(
            @PathVariable String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(jobService.getAllJobsByTitle(title, page, size));
    }

    @GetMapping(path = "/location/{location}")
    public ResponseEntity<Page<JobDTO>> getAllByLocation(
            @PathVariable String location,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(jobService.getAllJobsByLocation(location, page, size));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Page<JobDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(jobService.getAllJobs(PageRequest.of(page, size)));
    }
}
