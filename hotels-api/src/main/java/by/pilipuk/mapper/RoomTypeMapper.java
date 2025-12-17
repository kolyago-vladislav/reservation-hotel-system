package by.pilipuk.mapper;

import by.pilipuk.dto.DictCountryDto;
import by.pilipuk.dto.DictRoomTypeCountDto;
import by.pilipuk.dto.DictRoomTypeDto;
import by.pilipuk.entity.DictCountry;
import by.pilipuk.entity.DictRoomType;
import by.pilipuk.model.dto.RoomTypeCountProjection;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class RoomTypeMapper {

    public abstract DictRoomTypeCountDto from(RoomTypeCountProjection room);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "roomType", source = "name")
    public abstract DictRoomTypeDto from(DictRoomType dictRoomType);

}