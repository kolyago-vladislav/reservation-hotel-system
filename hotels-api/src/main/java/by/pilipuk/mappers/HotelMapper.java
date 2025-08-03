package by.pilipuk.mappers;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.entity.Hotel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HotelMapper {

    HotelDto toDto(Hotel hotel);

    Hotel toEntity(HotelDto hotelDto);

}
