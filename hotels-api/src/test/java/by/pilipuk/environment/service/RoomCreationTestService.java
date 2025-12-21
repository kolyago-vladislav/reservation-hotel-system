package by.pilipuk.environment.service;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.City;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.RoomType;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.RoomMapper;
import by.pilipuk.repository.CityRepository;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RoomCreationTestService {

    private final EntityCreators entityCreators;

    private final RoomMapper roomMapper;

    private final CityRepository cityRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Transactional
    public Room roomCreation() {

        City city = cityRepository.findByIdOrThrow(1L);

        RoomType roomType = roomTypeRepository.findByIdOrThrow(1L);

        Address address = entityCreators.addressCreator.createAddress(city);

        Hotel hotel = entityCreators.hotelCreator.createHotel(address);

        return entityCreators.roomCreator.createRoom(roomType, hotel);

    }

    @Transactional
    public RoomDto createRoomDto() {
        return roomMapper.from(roomCreation());
    }

}
