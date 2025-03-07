package com.lhind.jobportal.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class JobSeekerCreateDTO {
    @NotNull(message = "User details are required")
    private UserCreateDTO userDetails;

    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String skills;
    private Integer experienceYears;
    private String education;

    public JobSeekerCreateDTO() {
    }

    public UserCreateDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserCreateDTO userDetails) {
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
}