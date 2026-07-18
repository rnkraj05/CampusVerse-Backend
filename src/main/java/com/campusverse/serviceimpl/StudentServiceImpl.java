package com.campusverse.serviceimpl;

import com.campusverse.dto.StudentDTO;
import com.campusverse.entity.Student;
import com.campusverse.repository.StudentRepository;
import com.campusverse.response.ApiResponse;
import com.campusverse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public ApiResponse registerStudent(StudentDTO studentDTO) {

        if(studentRepository.existsByEmail(studentDTO.getEmail())){

            return new ApiResponse(false,
                    "Email already exists.",
                    null);

        }

        Student student = Student.builder()

                .fullName(studentDTO.getFullName())
                .email(studentDTO.getEmail())
                .password(studentDTO.getPassword())
                .phone(studentDTO.getPhone())
                .college(studentDTO.getCollege())
                .branch(studentDTO.getBranch())
                .semester(studentDTO.getSemester())
                .createdAt(LocalDateTime.now())
                .build();

        studentRepository.save(student);

        return new ApiResponse(
                true,
                "Student Registered Successfully",
                student);

    }

    @Override
    public ApiResponse getAllStudents() {

        return new ApiResponse(
                true,
                "Students List",
                studentRepository.findAll());

    }

    @Override
    public ApiResponse getStudentById(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return new ApiResponse(false, "Student Not Found", null);
        }

        return new ApiResponse(true, "Student Found", student);
    }

    @Override
    public ApiResponse updateStudent(Long id, StudentDTO dto) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return new ApiResponse(false, "Student Not Found", null);
        }

        student.setFullName(dto.getFullName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());
        student.setCollege(dto.getCollege());
        student.setBranch(dto.getBranch());
        student.setSemester(dto.getSemester());

        studentRepository.save(student);

        return new ApiResponse(true, "Student Updated Successfully", student);
    }

    @Override
    public ApiResponse deleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return new ApiResponse(false, "Student Not Found", null);
        }

        studentRepository.delete(student);

        return new ApiResponse(true, "Student Deleted Successfully", null);
    }

}