package by.pilipuk.mapper;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.entity.Hotel;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
    componentModel = "spring",
    uses = {AddressMapper.class}
)
public abstract class HotelMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "rating", target = "rating"),
            @Mapping(source = "address", target = "address")
    })
    public abstract HotelDto from(Hotel hotel);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "rating", target = "rating"),
            @Mapping(source = "address", target = "address")
    })
    public abstract Hotel to(HotelWriteDto hotelDto);

}
