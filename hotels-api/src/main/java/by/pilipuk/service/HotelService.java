package by.pilipuk.service;

import by.pilipuk.dto.dto.HotelDto;
import by.pilipuk.dto.dto.RoomTypeCountDto;
import by.pilipuk.dto.writeDto.HotelWriteDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.RoomType;
import by.pilipuk.mapper.AddressMapper;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
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
                .map(hotelMapper::toDto)
                .toList();
    }

    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);

    }

    public void addHotel(HotelWriteDto hotelWriteDto) {
        Hotel hotel = hotelMapper.toEntity(hotelWriteDto);
        hotelRepository.save(hotel);
    }

    public List<HotelDto> findHotelWithRoomTypeCounts() {
        List<Object[]> rows = roomRepository.findRoomTypeCountsByHotel();
        List<HotelDto> hotelDtos = new ArrayList<>();

        for(Object[] row : rows) {
            Long hotelId = ((Number) row[0]).longValue();
            Hotel hotel = hotelRepository.findById(hotelId)
                    .orElseThrow(() -> new RuntimeException("Hotel not found by id: " + hotelId));

            Long roomTypeId = ((Number) row[1]).longValue();
            int count = ((Number) row[2]).intValue();

            String roomType = roomTypeRepository.findById(roomTypeId)
                    .map(RoomType::getRoomType)
                    .orElse("roomType not found by id: " + roomTypeId);
            RoomTypeCountDto countRoomTypes = new RoomTypeCountDto(roomType, count);

            hotelDtos.add(new HotelDto(
                    hotel.getId(),
                    hotel.getName(),
                    hotel.getRating(),
                    addressMapper.from(hotel.getAddress()),
                    listOf(countRoomTypes)
            ));
        }
        return hotelDtos;
    }

}