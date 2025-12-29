package by.pilipuk.mapper;

import java.util.List;
import by.pilipuk.dto.RoomRequestDto;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.base.BaseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
            (CollectionUtils.isEmpty(roomIds))
                ? cb.conjunction()
                : root.get(BaseEntity.Fields.id).in(roomIds);
    }

    private static Specification<Room> hasHotelIds(List<Long> hotelIds) {
        return (root, query, cb) ->
            (CollectionUtils.isEmpty(hotelIds))
                ? cb.conjunction()
                : root.get(Room.Fields.hotel).get(BaseEntity.Fields.id).in(hotelIds);
    }

    private static Specification<Room> hasRoomTypeIds(List<Long> roomTypeIds) {
        return (root, query, cb) ->
            (CollectionUtils.isEmpty(roomTypeIds))
                ? cb.conjunction()
                : root.get(Room.Fields.roomType).get(BaseEntity.Fields.id).in(roomTypeIds);
    }

}
