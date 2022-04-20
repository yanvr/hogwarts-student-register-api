package com.letscode.hogwartsstudentregister.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse {

    private String field;
    private String errorMessage;
    private LocalDateTime timestamp;
}
