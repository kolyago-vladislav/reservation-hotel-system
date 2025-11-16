package by.pilipuk.environment.data.dtoCreators.writeDto;

import org.openapitools.model.RoomTypeCountWriteDto;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeCountWriteDtoCreator {

    public RoomTypeCountWriteDto createRoomTypeCountDto() {
        return new RoomTypeCountWriteDto()
                .roomType("Business")
                .count(50);
    }
}