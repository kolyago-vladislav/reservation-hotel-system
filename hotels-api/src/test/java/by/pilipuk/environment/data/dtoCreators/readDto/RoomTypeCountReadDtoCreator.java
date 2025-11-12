package by.pilipuk.environment.data.dtoCreators.readDto;

import by.pilipuk.dto.dto.RoomTypeCountDto;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeCountReadDtoCreator {

    public RoomTypeCountDto createRoomTypeCountDto() {
        return new RoomTypeCountDto(
                "business",
                (int) 50
        );
    }
}