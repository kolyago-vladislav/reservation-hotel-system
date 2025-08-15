package by.pilipuk.mappers;

import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.entity.RoomType;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoomTypeMapper {

    public abstract RoomTypeDto toDto(RoomType roomType);

    public abstract RoomType toEntity(RoomTypeDto roomTypeDto);
}