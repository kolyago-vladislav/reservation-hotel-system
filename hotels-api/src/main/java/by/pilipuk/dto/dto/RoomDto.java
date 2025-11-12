package by.pilipuk.dto.dto;

public record RoomDto(
    Long id,
    String description,
    String roomType,
    Long hotelId
) {}