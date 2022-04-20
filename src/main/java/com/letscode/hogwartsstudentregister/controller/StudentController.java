package com.letscode.hogwartsstudentregister.controller;

import com.letscode.hogwartsstudentregister.dto.StudentRequest;
import com.letscode.hogwartsstudentregister.dto.StudentResponse;
import com.letscode.hogwartsstudentregister.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse save(@Valid @RequestBody StudentRequest studentRequest) {
        return studentService.save(studentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse findById(@PathParam("id") Long id) {
        return studentService.findById(id);
    }
}
