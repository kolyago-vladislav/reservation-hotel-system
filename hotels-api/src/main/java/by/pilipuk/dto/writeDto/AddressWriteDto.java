package by.pilipuk.dto.writeDto;

public record AddressWriteDto(
        String street,
        String houseNumber,
        String country,
        String city
) {
}