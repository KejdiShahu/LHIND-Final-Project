package com.lhind.jobportal.model.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_seeker")
public class JobSeeker {
    @Id
    @Column(name = "user_id")
    private Long userId;

    @OneToOne
    @JoinColumn(name = "user_id")
    @MapsId
    private UserDetails userDetails;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "resume_url")
    private String resumeUrl;

    @Column(name = "skills")
    private String skills;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "education")
    private String education;

    @OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications = new ArrayList<>();

    public JobSeeker() {
    }

    public JobSeeker(UserDetails userDetails, String phoneNumber, LocalDate dateOfBirth, String skills, Integer experienceYears, String education) {
        this.userDetails = userDetails;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.skills = skills;
        this.experienceYears = experienceYears;
        this.education = education;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    public void addApplication(Application application) {
        applications.add(application);
        application.setJobSeeker(this);
    }

    public void removeApplication(Application application) {
        applications.remove(application);
        application.setJobSeeker(null);
    }
}