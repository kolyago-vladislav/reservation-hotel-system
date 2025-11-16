package by.pilipuk.environment.data.dtoCreators.writeDto;

import org.openapitools.model.AddressWriteDto;
import org.openapitools.model.HotelWriteDto;
import org.openapitools.model.RoomTypeCountWriteDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HotelWriteDtoCreator {

    public HotelWriteDto createHotelDto(AddressWriteDto addressWriteDto, List<RoomTypeCountWriteDto> roomTypeCountWriteDto) {
        return new HotelWriteDto()
                .name("My test hotel")
                .rating(5)
                .address(addressWriteDto)
                .roomTypeCountWriteDto(roomTypeCountWriteDto);
    }
}