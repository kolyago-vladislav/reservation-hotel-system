package by.pilipuk.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.mapper.AddressMapper;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.mapper.RoomTypeMapper;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;

    private final AddressMapper addressMapper;

    private final HotelRepository hotelRepository;

    private final RoomRepository roomRepository;

    private final RoomTypeMapper roomTypeMapper;

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::from)
                .toList();
    }

    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);

    }

    public void addHotel(HotelWriteDto hotelWriteDto) {
        Hotel hotel = hotelMapper.to(hotelWriteDto);
        hotelRepository.save(hotel);
    }

    public List<HotelDto> findHotelWithRoomTypeCounts() {
        List<HotelDto> hotelDtos = new ArrayList<>();

        var hotels = hotelRepository.findAll();
        var countRoomTypes = getRoomTypeCountMap();

        for (Hotel hotel : hotels) {
            var hotelDto = new HotelDto()
                    .id(hotel.getId())
                    .name(hotel.getName())
                    .rating(Integer.valueOf(hotel.getRating()))
                    .address(addressMapper.from(hotel.getAddress()))
                    .roomTypeCountDto(countRoomTypes.get(hotel.getId()));

            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }

    private Map<Long, List<RoomTypeCountDto>> getRoomTypeCountMap() {
        return roomRepository.findRoomTypeCountsByHotel()
            .stream()
            .collect(groupingBy(RoomTypeCountProjection::hotelId, mapping(roomTypeMapper::from, Collectors.toList())));
    }

}
