package com.letscode.hogwartsstudentregister.service;

import com.letscode.hogwartsstudentregister.dto.StudentRequest;
import com.letscode.hogwartsstudentregister.dto.StudentResponse;

public interface StudentService {

    StudentResponse save(StudentRequest studentRequest);

    StudentResponse findById(Long id);
}
