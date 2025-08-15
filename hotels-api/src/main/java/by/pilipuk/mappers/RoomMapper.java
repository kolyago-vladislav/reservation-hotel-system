package by.pilipuk.mappers;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    public abstract RoomDto toDto(Room room);

    public abstract Room toEntity(RoomDto roomDto);

}