package by.pilipuk.mapper;

import by.pilipuk.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.openapitools.model.RoomDto;

@Mapper(componentModel = "spring")
public abstract class RoomMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "roomType.roomType", target = "roomType"),
            @Mapping(source = "hotel.id", target = "hotelId"),
    })
    public abstract RoomDto from(Room room);

}