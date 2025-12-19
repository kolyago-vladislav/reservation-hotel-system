package by.pilipuk.mapper;

import java.util.List;
import by.pilipuk.dto.RoomRequestDto;
import by.pilipuk.entity.Room;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class RoomSpecificationMapper {
    private RoomSpecificationMapper() {}

    public Specification<Room> roomSpecification(RoomRequestDto roomRequestDto) {
        return Specification.allOf(
            hasRoomIds(roomRequestDto.getRoomIds()),
            hasHotelIds(roomRequestDto.getHotelIds()),
            hasRoomTypeIds(roomRequestDto.getRoomTypeIds()));
    }

    private static Specification<Room> hasRoomIds(List<Long> roomIds) {
        return (root, query, cb) ->
            (roomIds == null || roomIds.isEmpty())
                ? cb.conjunction()
                : root.get("id").in(roomIds);
    }

    private static Specification<Room> hasHotelIds(List<Long> hotelIds) {
        return (root, query, cb) ->
            (hotelIds == null || hotelIds.isEmpty())
                ? cb.conjunction()
                : root.get("hotel").get("id").in(hotelIds);
    }

    private static Specification<Room> hasRoomTypeIds(List<Long> roomTypeIds) {
        return (root, query, cb) ->
            (roomTypeIds == null || roomTypeIds.isEmpty())
                ? cb.conjunction()
                : root.get("roomType").get("id").in(roomTypeIds);
    }

}
