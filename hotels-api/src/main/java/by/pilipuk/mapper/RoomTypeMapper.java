package by.pilipuk.mapper;

import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.model.dto.RoomTypeCountAggregationDto;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class RoomTypeMapper {

    public abstract RoomTypeCountDto from(RoomTypeCountAggregationDto room);

}