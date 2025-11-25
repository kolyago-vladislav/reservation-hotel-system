package by.pilipuk.environment.data.dtoCreators.writeDto;

import by.pilipuk.dto.AddressWriteDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountWriteDto;
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