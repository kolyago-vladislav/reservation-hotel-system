package by.pilipuk.service;

import by.pilipuk.entity.Hotel;
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
        List<HotelDto> hotelDtos = new ArrayList<>();

        List<Hotel> hotels = hotelRepository.findAll();
        for (Hotel hotel:hotels) {
            List<RoomTypeCountDto> countRoomTypes = roomRepository.findRoomTypeCountsByHotel(hotel.getId());
            HotelDto hotelDto = new HotelDto()
                    .id(hotel.getId())
                    .name(hotel.getName())
                    .rating(Integer.valueOf(hotel.getRating()))
                    .address(addressMapper.from(hotel.getAddress()))
                    .roomTypeCountDto(countRoomTypes);

            hotelDtos.add(hotelDto);
        }
        return hotelDtos;
    }

}
