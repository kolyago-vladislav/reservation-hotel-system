package by.pilipuk.model.dto;

import java.time.Instant;

public record ExceptionDto(
        int status,
        String code,
        String message,
        String url,
        Instant timestamp
) {
}
