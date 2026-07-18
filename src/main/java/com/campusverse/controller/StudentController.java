package com.campusverse.controller;

import com.campusverse.dto.StudentDTO;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ApiResponse registerStudent(
            @RequestBody StudentDTO studentDTO){

        return studentService.registerStudent(studentDTO);

    }

    @GetMapping
    public ApiResponse getAllStudents(){

        return studentService.getAllStudents();

    }

    @GetMapping("/{id}")
    public ApiResponse getStudentById(@PathVariable Long id) {

        return studentService.getStudentById(id);

    }

    @PutMapping("/{id}")
    public ApiResponse updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDTO dto) {

        return studentService.updateStudent(id, dto);

    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteStudent(@PathVariable Long id) {

        return studentService.deleteStudent(id);

    }

}