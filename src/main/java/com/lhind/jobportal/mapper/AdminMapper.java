package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.AdminDTO;
import com.lhind.jobportal.model.entity.Admin;

public class AdminMapper {

    public static AdminDTO toDTO(Admin admin) {
        if (admin == null) {
            return null;
        }

        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setUserId(admin.getUserId());
        adminDTO.setUserDetails(UserDetailsMapper.toDTO(admin.getUserDetails()));

        return adminDTO;
    }

    public static Admin toEntity(AdminDTO adminDTO) {
        if (adminDTO == null) {
            return null;
        }

        Admin admin = new Admin();
        admin.setUserId(adminDTO.getUserId());
        admin.setUserDetails(UserDetailsMapper.toEntity(adminDTO.getUserDetails()));

        return admin;
    }
}