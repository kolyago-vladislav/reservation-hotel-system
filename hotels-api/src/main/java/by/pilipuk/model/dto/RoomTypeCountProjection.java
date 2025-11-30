package by.pilipuk.model.dto;

public record RoomTypeCountProjection(
    Long hotelId,
    String roomType,
    Long count
) {

}
