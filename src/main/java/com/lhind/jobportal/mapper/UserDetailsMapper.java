package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.UserDetailsDTO;
import com.lhind.jobportal.model.entity.UserDetails;

public class UserDetailsMapper {

    public static UserDetailsDTO toDTO(UserDetails userDetails) {
        if (userDetails == null) {
            return null;
        }

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setId(userDetails.getId());
        userDetailsDTO.setFirstName(userDetails.getFirstName());
        userDetailsDTO.setLastName(userDetails.getLastName());
        userDetailsDTO.setEmail(userDetails.getEmail());
        userDetailsDTO.setRole(userDetails.getRole());
        userDetailsDTO.setCreatedAt(userDetails.getCreatedAt());
        userDetailsDTO.setUpdatedAt(userDetails.getUpdatedAt());
        userDetailsDTO.setActive(userDetails.isActive());

        return userDetailsDTO;
    }

    public static UserDetails toEntity(UserDetailsDTO userDetailsDTO) {
        if (userDetailsDTO == null) {
            return null;
        }

        UserDetails userDetails = new UserDetails();
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setFirstName(userDetailsDTO.getFirstName());
        userDetails.setLastName(userDetailsDTO.getLastName());
        userDetails.setEmail(userDetailsDTO.getEmail());
        userDetails.setRole(userDetailsDTO.getRole());
        userDetails.setCreatedAt(userDetailsDTO.getCreatedAt());
        userDetails.setUpdatedAt(userDetailsDTO.getUpdatedAt());
        userDetails.setActive(userDetailsDTO.isActive());

        return userDetails;
    }
}