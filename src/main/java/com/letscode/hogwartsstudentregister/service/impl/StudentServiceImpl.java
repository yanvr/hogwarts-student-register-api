package com.letscode.hogwartsstudentregister.service.impl;

import com.letscode.hogwartsstudentregister.client.GetSelectorHouseInfoClient;
import com.letscode.hogwartsstudentregister.client.GetSelectorHouseKeyClient;
import com.letscode.hogwartsstudentregister.dto.StudentRequest;
import com.letscode.hogwartsstudentregister.dto.StudentResponse;
import com.letscode.hogwartsstudentregister.dto.clients.HouseInfo;
import com.letscode.hogwartsstudentregister.exception.StudentNotFoundException;
import com.letscode.hogwartsstudentregister.model.Student;
import com.letscode.hogwartsstudentregister.repository.StudentRepository;
import com.letscode.hogwartsstudentregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final GetSelectorHouseKeyClient getSelectorHouseKeyClient;
    private final GetSelectorHouseInfoClient getSelectorHouseInfoClient;
    private final StudentRepository studentRepository;

    @Override
    public StudentResponse save(StudentRequest studentRequest) {
        Student student = new Student();

        BeanUtils.copyProperties(studentRequest, student);

        var houseSelectorKey = getSelectorHouseKeyClient.execute();

        student.setSelectorHouseKey(houseSelectorKey.getKey());

        Student savedStudent = studentRepository.save(student);

        return new StudentResponse(savedStudent);
    }

    @Override
    public StudentResponse findById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        HouseInfo houseInfo = getSelectorHouseInfoClient.execute(student.getSelectorHouseKey());

        StudentResponse studentResponse = new StudentResponse(student);
        studentResponse.setHouseInfo(houseInfo);

        return studentResponse;
    }
}
