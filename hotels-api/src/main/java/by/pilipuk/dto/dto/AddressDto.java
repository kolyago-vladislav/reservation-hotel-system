package by.pilipuk.dto.dto;

public record AddressDto(
        Long id,
        String street,
        String houseNumber,
        String country,
        String city
) {
}