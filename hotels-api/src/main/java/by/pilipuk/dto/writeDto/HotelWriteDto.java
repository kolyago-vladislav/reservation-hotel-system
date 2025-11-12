package by.pilipuk.dto.writeDto;

import java.util.List;

public record HotelWriteDto(
        String name,
        Short rating,
        AddressWriteDto address,
        List<RoomTypeCountWriteDto> roomTypeCountWriteDto
) {

}