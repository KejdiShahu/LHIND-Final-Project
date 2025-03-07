package com.lhind.jobportal.model.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employer")
public class Employer {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private UserDetails userDetails;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "company_description")
    private String companyDescription;

    @Column(name = "website")
    private String website;

    @Column(name = "location")
    private String location;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Job> jobs = new ArrayList<>();

    public Employer() {
    }

    public Employer(UserDetails userDetails, String companyName, String companyDescription, String website, String location) {
        this.userDetails = userDetails;
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.website = website;
        this.location = location;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
        job.setEmployer(this);
    }

    public void removeJob(Job job) {
        jobs.remove(job);
        job.setEmployer(null);
    }
}