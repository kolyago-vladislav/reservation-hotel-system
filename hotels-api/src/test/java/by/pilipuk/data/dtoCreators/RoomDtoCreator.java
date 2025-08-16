package by.pilipuk.data.dtoCreators;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.RoomDto;
import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.RoomType;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class RoomDtoCreator {

    public RoomDto createRoomDto(RoomType roomType, Hotel hotel) {
        return new RoomDto(
                null,
                "My test room in test hotel",
                roomType,
                hotel,
                true,
                Instant.parse("2025-05-14T19:47:15Z"),
                Instant.parse("2025-05-14T19:47:15.000Z")
        );
    }
}