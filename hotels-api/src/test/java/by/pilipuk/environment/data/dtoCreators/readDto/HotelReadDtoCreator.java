package by.pilipuk.environment.data.dtoCreators.readDto;

import org.openapitools.model.AddressDto;
import org.openapitools.model.HotelDto;
import org.openapitools.model.RoomTypeCountDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HotelReadDtoCreator {

    public HotelDto createHotelDto(AddressDto addressDto, List<RoomTypeCountDto> roomTypeCountDto) {
        return new HotelDto()
                .id(null)
                .name("My test hotel")
                .rating(5)
                .address(addressDto)
                .roomTypeCountDto(roomTypeCountDto);
    }
}