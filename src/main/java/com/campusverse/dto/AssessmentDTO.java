package com.campusverse.dto;

import lombok.Data;

@Data
public class AssessmentDTO {

    private String studentName;

    private String assessmentName;

    private Integer score;

    private Integer totalMarks;

    private String result;
}