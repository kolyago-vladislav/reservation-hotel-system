package by.pilipuk.controller;

import by.pilipuk.exeption.ProcessingException;
import by.pilipuk.exeption.ValidationException;
import by.pilipuk.exeption.base.BaseApplicationException;
import by.pilipuk.model.dto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.Instant;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseApplicationException.class)
    public ResponseEntity<ExceptionDto> handleApplicationException(BaseApplicationException ex, HttpServletRequest request) {

        switch (ex.getLevel()) {
            case ERROR -> log.error("[ERROR] {}", ex.getMessage(), ex);
            case DEBUG -> log.debug("[DEBUG] {}", ex.getMessage());
            default    -> log.info("[INFO] {}", ex.getMessage());
        }

        HttpStatus status = null;
        if (ex instanceof ValidationException) {
            status = HttpStatus.NOT_FOUND;
        }
        if (ex instanceof ProcessingException) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ExceptionDto dto = new ExceptionDto(
                Objects.requireNonNull(status).value(),
                ex.getContext().getCode(),
                ex.getMessage(),
                request.getRequestURI(),
                Instant.now()
        );

        return new ResponseEntity<>(dto, status);
    }
}
