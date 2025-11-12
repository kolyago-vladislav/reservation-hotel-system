package by.pilipuk.dto.dto;

import java.util.List;

public record HotelDto(
    Long id,
    String name,
    Short rating,
    AddressDto address,
    List<RoomTypeCountDto> roomTypeCountDto
) {
}