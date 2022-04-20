package com.letscode.hogwartsstudentregister.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class StudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String grade;
}
