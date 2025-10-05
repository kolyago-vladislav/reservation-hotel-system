package by.pilipuk.mapper;

import by.pilipuk.dto.dto.RoomDto;
import by.pilipuk.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    @Named("fromRoom")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "roomType.roomType", target = "roomType"),
            @Mapping(source = "hotel.id", target = "hotelId"),
    })
    public abstract RoomDto toDto(Room room);

}