package com.lhind.jobportal.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmployerCreateDTO {
    @NotNull(message = "User details are required")
    private UserCreateDTO userDetails;

    @NotBlank(message = "Company name is required")
    private String companyName;

    private String companyDescription;
    private String website;
    private String location;

    public EmployerCreateDTO() {
    }

    public UserCreateDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserCreateDTO userDetails) {
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
}