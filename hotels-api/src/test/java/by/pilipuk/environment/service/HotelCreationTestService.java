package by.pilipuk.environment.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;
import by.pilipuk.entity.Hotel;
import by.pilipuk.environment.data.DtoCreators;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.HotelMapper;
import java.util.Collections;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class HotelCreationTestService {

    private final EntityCreators entityCreators;

    private final HotelMapper hotelMapper;

    private final DtoCreators dtoCreators;

    @Transactional
    public Hotel hotelCreation() {

        DictCity dictCity = entityCreators.dictCityCreator.createDictCity();

        DictCountry dictCountry = entityCreators.dictCountryCreator.createDictCountry();

        Address address = entityCreators.addressCreator.createAddress(dictCountry, dictCity);

        return entityCreators.hotelCreator.createHotel(address);

    }

    @Transactional
    public HotelDto createHotelDto() {

        return hotelMapper.from(hotelCreation());
    }

    @Transactional
    public HotelWriteDto createHotelWriteDto() {

        return dtoCreators.writeHotel.createHotelDto(dtoCreators.addressWriteDto.createAddressWriteDto(),
                Collections.singletonList(dtoCreators.writeRoomTypeCount.createRoomTypeCountDto()));
    }

    @Transactional
    public RoomTypeCountDto roomTypeCountDtoCreation() {

        return dtoCreators.readRoomTypeCount.createRoomTypeCountDto();
    }

}