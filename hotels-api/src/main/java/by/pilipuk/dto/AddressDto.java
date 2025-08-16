package by.pilipuk.dto;

import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;

import java.time.Instant;

public record AddressDto(
        Long id,
        String street,
        String houseNumber,
        DictCountry dictCountry,
        DictCity dictCity,
        boolean active,
        Instant created,
        Instant updated
) {
}
