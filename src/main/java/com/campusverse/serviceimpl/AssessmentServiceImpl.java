package com.campusverse.serviceimpl;

import com.campusverse.dto.AssessmentDTO;
import com.campusverse.entity.Assessment;
import com.campusverse.repository.AssessmentRepository;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public ApiResponse saveAssessment(AssessmentDTO assessmentDTO) {

        Assessment assessment = Assessment.builder()
                .studentName(assessmentDTO.getStudentName())
                .assessmentName(assessmentDTO.getAssessmentName())
                .score(assessmentDTO.getScore())
                .totalMarks(assessmentDTO.getTotalMarks())
                .result(assessmentDTO.getResult())
                .submittedAt(LocalDateTime.now())
                .build();

        assessmentRepository.save(assessment);

        return new ApiResponse(
                true,
                "Assessment Saved Successfully",
                assessment
        );
    }

    @Override
    public ApiResponse getAllAssessments() {

        return new ApiResponse(
                true,
                "Assessment List",
                assessmentRepository.findAll()
        );
    }
}