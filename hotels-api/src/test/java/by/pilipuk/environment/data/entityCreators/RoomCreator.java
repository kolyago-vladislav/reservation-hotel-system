package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Room;
import by.pilipuk.entity.RoomType;
import by.pilipuk.entity.Hotel;
import by.pilipuk.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class RoomCreator {

    private final RoomRepository roomRepository;

    public Room createRoom(RoomType roomType, Hotel hotel) {

        Room room = new Room();
        room.setRoomType(roomType);
        room.setDescription("My test room in test hotel");
        room.setHotel(hotel);
        room.setActive(true);
        room.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        room.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));

        return roomRepository.save(room);
    }
}
