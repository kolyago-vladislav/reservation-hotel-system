package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.DictRoomType;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.Hotel;
import by.pilipuk.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomCreator {

    private final RoomRepository roomRepository;

    public Room createRoom(DictRoomType roomType, Hotel hotel) {

        Room room = new Room()
        .setDictRoomType(roomType)
        .setDescription("My test room in test hotel")
        .setHotel(hotel);

        return roomRepository.save(room);
    }
}
