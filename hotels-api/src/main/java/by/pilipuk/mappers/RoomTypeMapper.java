package by.pilipuk.mappers;

import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.entity.RoomType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTypeMapper {

    RoomTypeDto toDto(RoomType roomType);

    RoomType toEntity(RoomTypeDto roomTypeDto);
}