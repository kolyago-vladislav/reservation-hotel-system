package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.RoomType;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class RoomTypeCreator {

    private final RoomTypeRepository roomTypeRepository;

    public RoomType createRoomType() {

        RoomType roomType = new RoomType();
        roomType.setRoomType("Business");
        roomType.setActive(true);
        roomType.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        roomType.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));

        return roomTypeRepository.save(roomType);
    }
}