package com.letscode.hogwartsstudentregister.dto;

import com.letscode.hogwartsstudentregister.dto.clients.HouseInfo;
import com.letscode.hogwartsstudentregister.model.Student;
import lombok.Data;

@Data
public class StudentResponse {

    private Long id;
    private String name;
    private String grade;
    private HouseInfo houseInfo;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.grade = student.getGrade();
    }
}
