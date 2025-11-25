package by.pilipuk.environment.data.dtoCreators.readDto;

import by.pilipuk.dto.RoomTypeCountDto;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeCountReadDtoCreator {

    public RoomTypeCountDto createRoomTypeCountDto() {
        return new RoomTypeCountDto()
                .roomType("business")
                .count(50);
    }
}