package by.pilipuk.environment.service;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.RoomType;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.RoomMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RoomCreationTestService {

    private final EntityCreators entityCreators;

    private final RoomMapper roomMapper;

    @Transactional
    public Room roomCreation() {

        DictCity dictCity = entityCreators.dictCityCreator.createDictCity();

        DictCountry dictCountry = entityCreators.dictCountryCreator.createDictCountry();

        RoomType roomType = entityCreators.roomTypeCreator.createRoomType();

        Address address = entityCreators.addressCreator.createAddress(dictCountry, dictCity);

        Hotel hotel = entityCreators.hotelCreator.createHotel(address);

        return entityCreators.roomCreator.createRoom(roomType, hotel);

    }

    @Transactional
    public RoomDto createRoomDto() {
        return roomMapper.from(roomCreation());
    }

}
