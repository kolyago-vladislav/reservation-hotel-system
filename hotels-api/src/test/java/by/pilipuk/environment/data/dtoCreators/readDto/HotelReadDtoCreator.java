package by.pilipuk.environment.data.dtoCreators.readDto;

import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.RoomTypeCountDto;
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