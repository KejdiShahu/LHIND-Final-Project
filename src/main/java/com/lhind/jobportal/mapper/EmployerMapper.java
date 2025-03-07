package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.EmployerDTO;
import com.lhind.jobportal.model.entity.Employer;

public class EmployerMapper {
    public static EmployerDTO toDTO(Employer employer) {
        if (employer == null) {
            return null;
        }

        EmployerDTO employerDTO = new EmployerDTO();
        employerDTO.setUserId(employer.getUserId());
        employerDTO.setUserDetails(UserDetailsMapper.toDTO(employer.getUserDetails()));
        employerDTO.setCompanyName(employer.getCompanyName());
        employerDTO.setCompanyDescription(employer.getCompanyDescription());
        employerDTO.setWebsite(employer.getWebsite());
        employerDTO.setLocation(employer.getLocation());

        return employerDTO;
    }

    public static Employer toEntity(EmployerDTO employerDTO) {
        if (employerDTO == null) {
            return null;
        }

        Employer employer = new Employer();
        employer.setUserId(employerDTO.getUserId());
        employer.setUserDetails(UserDetailsMapper.toEntity(employerDTO.getUserDetails()));
        employer.setCompanyName(employerDTO.getCompanyName());
        employer.setCompanyDescription(employerDTO.getCompanyDescription());
        employer.setWebsite(employerDTO.getWebsite());
        employer.setLocation(employerDTO.getLocation());

        return employer;
    }
}