package by.pilipuk.environment.data.dtoCreators.writeDto;

import by.pilipuk.dto.writeDto.AddressWriteDto;
import by.pilipuk.dto.writeDto.HotelWriteDto;
import by.pilipuk.dto.writeDto.RoomTypeCountWriteDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HotelWriteDtoCreator {

    public HotelWriteDto createHotelDto(AddressWriteDto addressWriteDto, List<RoomTypeCountWriteDto> roomTypeCountWriteDto) {
        return new HotelWriteDto(
                "My test hotel",
                (short) 5,
                addressWriteDto,
                roomTypeCountWriteDto
        );
    }
}