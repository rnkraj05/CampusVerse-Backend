package com.campusverse.service;

import com.campusverse.dto.AssessmentDTO;
import com.campusverse.response.ApiResponse;

public interface AssessmentService {

    ApiResponse saveAssessment(AssessmentDTO assessmentDTO);

    ApiResponse getAllAssessments();

}