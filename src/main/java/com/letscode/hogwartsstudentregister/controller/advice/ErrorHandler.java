package com.letscode.hogwartsstudentregister.controller.advice;

import com.letscode.hogwartsstudentregister.dto.exceptions.ExceptionResponse;
import com.letscode.hogwartsstudentregister.exception.StudentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {

    private final MessageSource messageSource;
    private static final String ZONE_ID = "America/Sao_Paulo";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ExceptionResponse> ilegalArgumentExceptionHandler(MethodArgumentNotValidException e) {
        List<ExceptionResponse> errors = new ArrayList<>();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            ExceptionResponse exceptionResponse = new ExceptionResponse(
                    fieldError.getField(),
                    message,
                    LocalDateTime.now(ZoneId.of(ZONE_ID))
            );
            errors.add(exceptionResponse);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public ExceptionResponse ilegalArgumentExceptionHandler(StudentNotFoundException e) {
       return new ExceptionResponse(
               "Student not found",
               e.getMessage(),
               LocalDateTime.now(ZoneId.of(ZONE_ID))
       );
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(HttpClientErrorException.class)
    public ExceptionResponse httpClientErrorExcpetionHandler(HttpClientErrorException e) {
        return new ExceptionResponse(
                "Service is unavailable",
                e.getMessage(),
                LocalDateTime.now(ZoneId.of(ZONE_ID))
        );
    }
}
