package by.pilipuk.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.mapper.AddressMapper;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.mapper.RoomTypeMapper;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        var hotels = hotelRepository.findAll()
            .stream()
            .map(hotelMapper::from)
            .toList();

        var countRoomTypes = getRoomTypeCountMap();

        hotels.forEach(hotel -> hotel.setRoomTypeCountDto(countRoomTypes.get(hotel.getId())));

        return hotels;
    }

    public Optional<Hotel> getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId);

    }

    @Transactional
    public void addHotel(HotelWriteDto hotelWriteDto) {
        Hotel hotel = hotelMapper.to(hotelWriteDto);

        Set<Room> rooms = hotel.getRooms();
        if (rooms != null) {
            for (Room room : rooms) {
                room.setHotel(hotel);
            }
        }

        hotelRepository.save(hotel);
    }

    private Map<Long, List<RoomTypeCountDto>> getRoomTypeCountMap() {
        return roomRepository.findRoomTypeCountsByHotel()
            .stream()
            .collect(groupingBy(RoomTypeCountProjection::hotelId, mapping(roomTypeMapper::from, Collectors.toList())));
    }

}