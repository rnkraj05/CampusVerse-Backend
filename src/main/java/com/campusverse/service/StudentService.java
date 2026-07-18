package com.campusverse.service;

import com.campusverse.dto.StudentDTO;
import com.campusverse.response.ApiResponse;

public interface StudentService {

    ApiResponse registerStudent(StudentDTO studentDTO);

    ApiResponse getAllStudents();

    ApiResponse getStudentById(Long id);

    ApiResponse updateStudent(Long id, StudentDTO dto);

    ApiResponse deleteStudent(Long id);

}