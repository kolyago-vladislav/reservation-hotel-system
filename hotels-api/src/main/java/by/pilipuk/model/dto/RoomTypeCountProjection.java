package by.pilipuk.model.dto;

public record RoomTypeCountProjection(
    Long hotelId,
    String dictRoomType,
    Long count
) {

}
