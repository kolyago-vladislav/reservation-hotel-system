package by.pilipuk.environment.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelPageDto;
import by.pilipuk.dto.HotelRequestDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.City;
import by.pilipuk.entity.Hotel;
import by.pilipuk.environment.data.DtoCreators;
import by.pilipuk.environment.data.EntityCreators;
import by.pilipuk.mapper.HotelMapper;
import java.util.Collections;
import java.util.List;

import by.pilipuk.repository.CityRepository;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.stream.Collectors.groupingBy;

@Component
@RequiredArgsConstructor
public class HotelCreationTestService {

    private final HotelMapper hotelMapper;

    private final EntityCreators entityCreators;
    private final DtoCreators dtoCreators;

    private final CityRepository cityRepository;
    private final RoomTypeRepository roomTypeRepository;

    @Transactional
    public Hotel createHotel() {

        City city = cityRepository.findByIdOrThrow(1L);

        Address address = entityCreators.addressCreator.createAddress(city);

        return entityCreators.hotelCreator.createHotel(address);

    }

    @Transactional
    public HotelDto createHotelDto() {

        return hotelMapper.from(createHotel());
    }

    @Transactional
    public HotelWriteDto createHotelWriteDto() {

        return dtoCreators.writeHotel.createHotelDto(dtoCreators.addressWriteDto.createAddressWriteDto(),
                Collections.singletonList(dtoCreators.writeRoomTypeCount.createRoomTypeCountDto()));
    }

    @Transactional
    public HotelPageDto createHotelPageDto() {

        var newHotel = createHotel();

        var newRoom = entityCreators.roomCreator.createRoom(roomTypeRepository.findByIdOrThrow(1L), newHotel);

        Pageable pageable = PageRequest.of(0, 20);
        var hotelList = Collections.singletonList(newHotel);
        var pageHotels = new PageImpl<>(hotelList, pageable, hotelList.size());

        return hotelMapper.toHotelPageDto(pageHotels);
    }

    @Transactional
    public HotelRequestDto createHotelRequestDto() {
        var hotelRequestDto = new HotelRequestDto();
        hotelRequestDto.setNames(Collections.singletonList("My test hotel"));
        hotelRequestDto.setCityIds(List.of(1L));
        hotelRequestDto.setRatingFrom(1);
        hotelRequestDto.setRatingTo(5);
        return hotelRequestDto;
    }
}