package com.lhind.jobportal.service;

import com.lhind.jobportal.mapper.AdminMapper;
import com.lhind.jobportal.model.dto.AdminDTO;
import com.lhind.jobportal.model.dto.EmployerDTO;
import com.lhind.jobportal.model.dto.JobSeekerDTO;
import com.lhind.jobportal.model.dto.UserDTO;
import com.lhind.jobportal.model.entity.Admin;
import com.lhind.jobportal.repository.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Page<AdminDTO> getAllAdmins(int page, int size) {
        Page<Admin> admins = adminRepository.findAll(PageRequest.of(page, size));
        return admins.map(AdminMapper::toDTO);
    }

}
