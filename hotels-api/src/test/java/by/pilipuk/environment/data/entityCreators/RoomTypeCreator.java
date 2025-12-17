package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.DictRoomType;
import by.pilipuk.repository.DictRoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RoomTypeCreator {

    private final DictRoomTypeRepository roomTypeRepository;

    @Transactional
    public DictRoomType createRoomType() {

        DictRoomType roomType = new DictRoomType()
        .setName("Business");

        return roomTypeRepository.save(roomType);
    }
}