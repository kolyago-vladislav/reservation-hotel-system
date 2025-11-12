package by.pilipuk.environment.service;

import by.pilipuk.dto.dto.RoomDto;
import by.pilipuk.entity.*;
import by.pilipuk.environment.data.DtoCreators;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomCreationTestService {

    private final DtoCreators dtoCreators;

    private final EntityCreators entityCreators;

    private final RoomMapper roomMapper;

    private final HotelMapper hotelMapper;

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

//    public HotelDto createHotelDto() {
//
//        RoomTypeCountWriteDto roomTypeCountWriteDto = dtoCreators.writeRoomTypeCount.createRoomTypeCountDto();
//
//        return dtoCreators.writeHotel.createHotelDto(updateAddressWriteDto, new ArrayList<>(Collections.singleton(roomTypeCountWriteDto)));
////        Hotel hotel = hotelRepository.save(hotelMapper.to(hotelWriteDto));
//    }
}
