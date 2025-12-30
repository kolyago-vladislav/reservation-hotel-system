package by.pilipuk.controller;

import by.pilipuk.exeption.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Map<String, Object>> handleNotFoundException(ValidationException ex) {
        String errorCode = ex.getContext().getCode();

        log.debug("[Element Not Found] Code: {}, Id: {}", errorCode, ex.getContext().getParameters());

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", OffsetDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("errorCode", errorCode);
        body.put("details", ex.getContext().getParameters());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}
