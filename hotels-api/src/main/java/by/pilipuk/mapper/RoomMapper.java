package by.pilipuk.mapper;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "roomType", source = "roomType.roomType")
    @Mapping(target = "hotelId", source = "hotel.id")
    public abstract RoomDto from(Room room);

}