package com.campusverse.controller;

import com.campusverse.dto.AssessmentDTO;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assessments")
@CrossOrigin("*")
public class AssessmentController {

    @Autowired
    private AssessmentService assessmentService;

    @PostMapping
    public ApiResponse saveAssessment(@RequestBody AssessmentDTO assessmentDTO) {

        return assessmentService.saveAssessment(assessmentDTO);
    }

    @GetMapping
    public ApiResponse getAllAssessments() {

        return assessmentService.getAllAssessments();
    }
}