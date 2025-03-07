package com.lhind.jobportal.service;

import com.lhind.jobportal.mapper.EmployerMapper;
import com.lhind.jobportal.model.dto.EmployerDTO;
import com.lhind.jobportal.model.entity.Employer;
import com.lhind.jobportal.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public Page<EmployerDTO> getAllEmployers(int page, int size) {
        Page<Employer> employers = employerRepository.findAll(PageRequest.of(page, size));
        return employers.map(EmployerMapper::toDTO);
    }

    public EmployerDTO getEmployerById(Long id) {
        Employer employer = employerRepository.findById(id).orElse(null);
        return EmployerMapper.toDTO(employer);
    }

    public boolean existsById(Long id) {
        return employerRepository.existsById(id);
    }
}
