package com.lhind.jobportal.mapper;

import com.lhind.jobportal.model.dto.ResumeDTO;
import com.lhind.jobportal.model.entity.Resume;

public class ResumeMapper {

    public static ResumeDTO toDTO(Resume resume) {
        if (resume == null) {
            return null;
        }

        ResumeDTO resumeDTO = new ResumeDTO();
        resumeDTO.setId(resume.getId());
        resumeDTO.setJobSeekerId(resume.getJobSeeker().getUserId());
        resumeDTO.setFileName(resume.getFileName());
        resumeDTO.setFilePath(resume.getFilePath());
        resumeDTO.setFileSize(resume.getFileSize());
        resumeDTO.setFileType(resume.getFileType());
        resumeDTO.setUploadedAt(resume.getUploadedAt());
        resumeDTO.setActive(resume.isActive());

        return resumeDTO;
    }

    public static Resume toEntity(ResumeDTO resumeDTO) {
        if (resumeDTO == null) {
            return null;
        }

        Resume resume = new Resume();
        resume.setId(resumeDTO.getId());
        resume.setFileName(resumeDTO.getFileName());
        resume.setFilePath(resumeDTO.getFilePath());
        resume.setFileSize(resumeDTO.getFileSize());
        resume.setFileType(resumeDTO.getFileType());
        resume.setUploadedAt(resumeDTO.getUploadedAt());
        resume.setActive(resumeDTO.isActive());

        return resume;
    }
}