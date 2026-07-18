package com.campusverse.dto;

import lombok.Data;

@Data
public class StudentDTO {

    private String fullName;

    private String email;

    private String password;

    private String phone;

    private String college;

    private String branch;

    private Integer semester;

}