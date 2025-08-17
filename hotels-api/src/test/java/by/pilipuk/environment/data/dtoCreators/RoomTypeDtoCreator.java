package by.pilipuk.environment.data.dtoCreators;

import by.pilipuk.dto.RoomTypeDto;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class RoomTypeDtoCreator {

    public RoomTypeDto createRoomTypeDto() {
        return new RoomTypeDto(
                null,
                "standart",
                true,
                Instant.parse("2025-05-14T19:47:15Z"),
                Instant.parse("2025-05-14T19:47:15.000Z")
        );
    }
}