package by.pilipuk.service;

import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.RoomType;
import by.pilipuk.mapper.AddressMapper;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountDto;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.hibernate.internal.util.collections.CollectionHelper.listOf;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;

    private final AddressMapper addressMapper;

    private final HotelRepository hotelRepository;

    private final RoomRepository roomRepository;

    private final RoomTypeRepository roomTypeRepository;

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
        List<RoomTypeCountDto> rows = roomRepository.findRoomTypeCountsByHotel();
        List<HotelDto> hotelDtos = new ArrayList<>();

        for(RoomTypeCountDto row : rows) {

            Long hotelId = row.getHotelId();
            Long roomTypeId = row.getRoomTypeId();
            Integer count = row.getCount();

            Hotel hotel = hotelRepository.findById(hotelId)
                    .orElseThrow(() -> new RuntimeException("Hotel not found by id: " + hotelId));

            String roomType = roomTypeRepository.findById(roomTypeId)
                    .map(RoomType::getRoomType)
                    .orElse("roomType not found by id: " + roomTypeId);

            RoomTypeCountDto countRoomTypes = new RoomTypeCountDto();
            countRoomTypes.setHotelId(hotelId);
            countRoomTypes.setRoomTypeId(roomTypeId);
            countRoomTypes.setCount(count);

            HotelDto hotelDto = new HotelDto()
                    .id(hotel.getId())
                    .name(hotel.getName())
                    .rating(Integer.valueOf(hotel.getRating()))
                    .address(addressMapper.from(hotel.getAddress()))
                    .roomTypeCountDto(listOf(countRoomTypes));

            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }

}