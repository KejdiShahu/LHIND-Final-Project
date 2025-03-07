package com.lhind.jobportal.model.dto;

public class AdminDTO {
    private Long userId;
    private UserDetailsDTO userDetails;

    public AdminDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserDetailsDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }
}