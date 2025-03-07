package com.lhind.jobportal.service;

import com.lhind.jobportal.model.dto.AdminDTO;
import com.lhind.jobportal.model.dto.EmployerDTO;
import com.lhind.jobportal.model.dto.JobSeekerDTO;
import com.lhind.jobportal.model.dto.UserDTO;
import com.lhind.jobportal.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EmployerService employerService;
    private final JobSeekerService jobSeekerService;
    private final AdminService adminService;

    @Autowired
    public UserService(UserRepository userRepository, EmployerService employerService, JobSeekerService jobSeekerService, AdminService adminService) {
        this.userRepository = userRepository;
        this.employerService = employerService;
        this.jobSeekerService = jobSeekerService;
        this.adminService = adminService;
    }

    public Page<UserDTO> getAllUsers(int page, int size) {
        Page<EmployerDTO> employersPage = employerService.getAllEmployers(page, size);
        Page<JobSeekerDTO> jobSeekersPage = jobSeekerService.getAllJobSeekers(page, size);
        Page<AdminDTO> adminsPage = adminService.getAllAdmins(page, size);

        List<UserDTO> allUsers = new ArrayList<>();

        for (EmployerDTO employer : employersPage.getContent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(employer.getUserId());
            userDTO.setUserType("EMPLOYER");
            userDTO.setUserDetails(employer.getUserDetails());
            allUsers.add(userDTO);
        }

        for (JobSeekerDTO jobSeeker : jobSeekersPage.getContent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(jobSeeker.getUserId());
            userDTO.setUserType("JOB_SEEKER");
            userDTO.setUserDetails(jobSeeker.getUserDetails());
            allUsers.add(userDTO);
        }

        for (AdminDTO admin : adminsPage.getContent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(admin.getUserId());
            userDTO.setUserType("ADMIN");
            userDTO.setUserDetails(admin.getUserDetails());
            allUsers.add(userDTO);
        }

        return new PageImpl<>(allUsers, PageRequest.of(page, size), allUsers.size());
    }

    @Transactional
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
