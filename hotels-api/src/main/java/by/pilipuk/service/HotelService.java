package by.pilipuk.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.PageHotelDto;
import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.mapper.AddressMapper;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.mapper.RoomTypeMapper;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public PageHotelDto findHotelsWithRoomTypeCounts(Integer offset, Integer limit) {
        Pageable pageable = PageRequest.of(offset, limit);

        Page<Hotel> hotelsPage = (Page<Hotel>) hotelRepository.findAll(pageable);
        Map<Long, List<RoomTypeCountDto>> countRoomTypes = getRoomTypeCountMap();

        List<HotelDto> hotelDtoList = hotelsPage.getContent().stream()
                .map(hotel -> new HotelDto()
                    .id(hotel.getId())
                    .name(hotel.getName())
                    .rating(Integer.valueOf(hotel.getRating()))
                    .address(addressMapper.from(hotel.getAddress()))
                    .roomTypeCountDto(countRoomTypes.get(hotel.getId()))
                )
                .toList();

        PageHotelDto pageHotelDto = new PageHotelDto();
        pageHotelDto.setContent(hotelDtoList);
        pageHotelDto.setTotalElements(hotelsPage.getTotalElements());
        pageHotelDto.setTotalPages(hotelsPage.getTotalPages());
        pageHotelDto.setSize(limit);
        pageHotelDto.setNumber(offset);
        return pageHotelDto;
    }

    private Map<Long, List<RoomTypeCountDto>> getRoomTypeCountMap() {
        return roomRepository.findRoomTypeCountsByHotel()
            .stream()
            .collect(groupingBy(RoomTypeCountProjection::hotelId, mapping(roomTypeMapper::from, Collectors.toList())));
    }

}