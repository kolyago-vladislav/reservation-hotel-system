package by.pilipuk.mapper;

import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.entity.RoomType;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Setter(onMethod_ = @Autowired)
public abstract class RoomTypeMapper {

    private RoomTypeRepository roomTypeRepository;

    @Mapping(target = "id", source = "roomTypeId")
    public abstract RoomTypeCountDto fromProjection(RoomTypeCountProjection room);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    public abstract RoomTypeDto from(RoomType RoomType);

    protected RoomType toRoomType(Long roomTypeId) {
        return roomTypeRepository.findByIdOrThrow(roomTypeId);
    }

}