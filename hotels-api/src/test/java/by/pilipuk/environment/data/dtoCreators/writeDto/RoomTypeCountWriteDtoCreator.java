package by.pilipuk.environment.data.dtoCreators.writeDto;

import by.pilipuk.dto.RoomTypeCountWriteDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoomTypeCountWriteDtoCreator {

    @Transactional
    public RoomTypeCountWriteDto createRoomTypeCountDto() {
        return new RoomTypeCountWriteDto()
                .roomType("Business")
                .count(50);
    }
}