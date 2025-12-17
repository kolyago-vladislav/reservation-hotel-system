package by.pilipuk.environment.service;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.City;
import by.pilipuk.entity.DictCountry;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.DictRoomType;
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

        City city = entityCreators.dictCityCreator.createDictCity();

        DictCountry dictCountry = entityCreators.dictCountryCreator.createDictCountry();

        DictRoomType roomType = entityCreators.roomTypeCreator.createRoomType();

        Address address = entityCreators.addressCreator.createAddress(dictCountry, city);

        Hotel hotel = entityCreators.hotelCreator.createHotel(address);

        return entityCreators.roomCreator.createRoom(roomType, hotel);

    }

    @Transactional
    public RoomDto createRoomDto() {
        return roomMapper.from(roomCreation());
    }

}
