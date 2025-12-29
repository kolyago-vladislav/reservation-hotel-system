package by.pilipuk.mapper;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.dto.RoomPageDto;
import by.pilipuk.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "roomTypeId", source = "roomType.id")
    @Mapping(target = "hotelId", source = "hotel.id")
    public abstract RoomDto from(Room room);

    public RoomPageDto toRoomPageDto(Page<Room> pageRooms) {
        var dto = new RoomPageDto();

        dto.setTotalCount(pageRooms.getTotalElements());
        dto.setTotalPages(pageRooms.getTotalPages());
        dto.setItems(pageRooms.getContent().stream()
                .map(this::from)
                .toList());
        return dto;
    }
}