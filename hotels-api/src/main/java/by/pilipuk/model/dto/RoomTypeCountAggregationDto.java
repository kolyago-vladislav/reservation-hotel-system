package by.pilipuk.model.dto;

public record RoomTypeCountAggregationDto(
    Long hotelId,
    String roomType,
    Long count
) {

}
