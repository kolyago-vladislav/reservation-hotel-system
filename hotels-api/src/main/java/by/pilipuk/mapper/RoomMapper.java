package by.pilipuk.mapper;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "dictRoomType", source = "dictRoomType.name")
    @Mapping(target = "hotel", source = "hotel.name")
    public abstract RoomDto from(Room room);

}