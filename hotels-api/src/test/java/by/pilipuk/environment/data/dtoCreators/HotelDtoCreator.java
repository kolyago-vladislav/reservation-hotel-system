package by.pilipuk.environment.data.dtoCreators;

import by.pilipuk.dto.dto.AddressDto;
import by.pilipuk.dto.dto.HotelDto;
import by.pilipuk.dto.dto.RoomTypeCountDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HotelDtoCreator {

    public HotelDto createHotelDto(AddressDto addressDto, List<RoomTypeCountDto> roomTypeCountDto) {
        return new HotelDto(
                null,
                "My test hotel",
                (short) 5,
                addressDto,
                roomTypeCountDto
        );
    }
}