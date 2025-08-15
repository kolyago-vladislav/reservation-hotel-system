package by.pilipuk.mappers;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.entity.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class HotelMapper {

    public abstract HotelDto toDto(Hotel hotel);

    public abstract Hotel toEntity(HotelDto hotelDto);

}
