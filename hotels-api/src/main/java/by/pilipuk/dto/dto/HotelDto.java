package by.pilipuk.dto.dto;

public record HotelDto(
    Long id,
    String name,
    Short rating,
    AddressDto address,
    RoomTypeCountDto roomTypeCountReadDto
) {
}