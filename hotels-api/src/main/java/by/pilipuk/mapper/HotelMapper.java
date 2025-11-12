package by.pilipuk.mapper;

import by.pilipuk.dto.dto.HotelDto;
import by.pilipuk.dto.writeDto.HotelWriteDto;
import by.pilipuk.entity.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class HotelMapper {

    @Named("fromHotel")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "rating", target = "rating"),
            @Mapping(source = "address", target = "address")
    })
    public abstract HotelDto from(Hotel hotel);

    @Named("toHotel")
    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "rating", target = "rating"),
            @Mapping(source = "address", target = "address")
    })
    public abstract Hotel to(HotelWriteDto hotelDto);

}
