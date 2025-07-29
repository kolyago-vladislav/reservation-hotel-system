package by.pilipuk.mappers;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper {

    RoomDto toDto(Room room);

    Room toEntity(RoomDto roomDto);

}