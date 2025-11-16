package by.pilipuk.environment.service;

import by.pilipuk.entity.*;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.RoomDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomCreationTestService {

    private final EntityCreators entityCreators;

    private final RoomMapper roomMapper;

    public Room roomCreation() {

        DictCity dictCity = entityCreators.dictCityCreator.createDictCity();

        DictCountry dictCountry = entityCreators.dictCountryCreator.createDictCountry();

        RoomType roomType = entityCreators.roomTypeCreator.createRoomType();

        Address address = entityCreators.addressCreator.createAddress(dictCountry, dictCity);

        Hotel hotel = entityCreators.hotelCreator.createHotel(address);

        return entityCreators.roomCreator.createRoom(roomType, hotel);

    }

    public RoomDto createRoomDto() {

        return roomMapper.from(roomCreation());
    }

}
