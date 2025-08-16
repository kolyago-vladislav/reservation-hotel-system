package by.pilipuk.dto;

import java.time.Instant;

public record DictCountryDto(
        Long id,
        String country,
        boolean active,
        Instant created,
        Instant updated
) {
}
