package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.RoomType;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RoomTypeCreator {

    private final RoomTypeRepository roomTypeRepository;

    @Transactional
    public RoomType createRoomType() {

        RoomType roomType = new RoomType()
        .setName("Business");

        return roomTypeRepository.save(roomType);
    }
}