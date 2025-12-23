package by.pilipuk.environment.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.City;
import by.pilipuk.entity.Hotel;
import by.pilipuk.environment.data.DtoCreators;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.HotelMapper;
import java.util.Collections;
import by.pilipuk.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class HotelCreationTestService {

    private final HotelMapper hotelMapper;

    private final EntityCreators entityCreators;
    private final DtoCreators dtoCreators;

    private final CityRepository cityRepository;

    @Transactional
    public Hotel hotelCreation() {

        City city = cityRepository.findByIdOrThrow(1L);

        Address address = entityCreators.addressCreator.createAddress(city);

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

}