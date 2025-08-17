package by.pilipuk.dto;

import java.time.Instant;

public record DictCityDto(
        Long id,
        String city,
        boolean active,
        Instant created,
        Instant updated
) {
}
