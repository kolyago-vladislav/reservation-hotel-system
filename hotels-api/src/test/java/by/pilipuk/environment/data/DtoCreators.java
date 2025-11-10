package by.pilipuk.environment.data;

import by.pilipuk.environment.data.dtoCreators.readDto.HotelReadDtoCreator;
import by.pilipuk.environment.data.dtoCreators.readDto.RoomTypeCountReadDtoCreator;
import by.pilipuk.environment.data.dtoCreators.writeDto.HotelWriteDtoCreator;
import by.pilipuk.environment.data.dtoCreators.writeDto.RoomTypeCountWriteDtoCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoCreators {

    public final HotelReadDtoCreator readHotel;

    public final HotelWriteDtoCreator writeHotel;

    public final RoomTypeCountReadDtoCreator readRoomTypeCount;

    public final RoomTypeCountWriteDtoCreator writeRoomTypeCount;

}