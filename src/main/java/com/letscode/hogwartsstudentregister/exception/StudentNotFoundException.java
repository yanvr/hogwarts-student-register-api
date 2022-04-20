package com.letscode.hogwartsstudentregister.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(Long id) {
        super("Estudante com o " + id + " não foi encontrado.");
    }
}
