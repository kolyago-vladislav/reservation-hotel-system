package by.pilipuk.service;

import by.pilipuk.dto.*;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.mapper.DictCityMapper;
import by.pilipuk.mapper.DictCountryMapper;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.mapper.RoomTypeMapper;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import by.pilipuk.repository.DictCityRepository;
import by.pilipuk.repository.DictCountryRepository;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import java.util.*;
import java.util.stream.Collectors;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;

    private final HotelRepository hotelRepository;

    private final RoomRepository roomRepository;

    private final DictCityRepository dictCityRepository;

    private final DictCityMapper dictCityMapper;

    private final DictCountryRepository dictCountryRepository;

    private final DictCountryMapper dictCountryMapper;

    private final RoomTypeMapper roomTypeMapper;

    public PageHotelDto getAllHotels(HotelSearchCriteria filterCriteria, Pageable pageable) {

        Specification<Hotel> spec = filterSpecificationForHotel(filterCriteria);

        var hotelDtos = hotelRepository.findAll(spec, pageable)
            .map(hotelMapper::from);

        var countRoomTypes = getRoomTypeCountMap();

        hotelDtos.forEach(hotelDto -> hotelDto.setDictRoomTypeCountDto(countRoomTypes.get(hotelDto.getId())));

        PageHotelDto pageHotelDto = new PageHotelDto();
        pageHotelDto.setContent(hotelDtos.getContent());
        pageHotelDto.setTotalElements(hotelDtos.getTotalElements());
        pageHotelDto.setTotalPages(hotelDtos.getTotalPages());
        pageHotelDto.setSize(hotelDtos.getSize());
        pageHotelDto.setNumberOfPage(hotelDtos.getNumber());

        return pageHotelDto;
    }

    public HotelDto getHotelById(Long hotelId) {
        var hotel = hotelRepository.findById(hotelId).orElseThrow(() -> new IllegalArgumentException("Hotel not found: " + hotelId));
        return hotelMapper.from(hotel);

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

    private Map<Long, List<DictRoomTypeCountDto>> getRoomTypeCountMap() {
        return roomRepository.findRoomTypeCountsByHotel()
            .stream()
            .collect(groupingBy(RoomTypeCountProjection::hotelId, mapping(roomTypeMapper::from, Collectors.toList())));
    }

    private Specification<Hotel> filterSpecificationForHotel(HotelSearchCriteria criteria) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (criteria.getHotelName() != null && !criteria.getHotelName().isBlank()) {
                predicates.add(builder.like(builder.lower(root.get("name")),
                        "%" + criteria.getHotelName().toLowerCase() + "%"));
            }
            if (criteria.getMinRating() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("rating"), criteria.getMinRating()));
            }
            if (criteria.getCityId() != null) {
                predicates.add(builder.equal(root.get("address").get("dictCity").get("id"), criteria.getCityId()));
            }
            if (criteria.getCountryId() != null) {
                predicates.add(builder.equal(root.get("address").get("dictCountry").get("id"), criteria.getCountryId()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public List<DictCityDto> getAllDictCities() {
        return dictCityRepository.findAll().stream().map(dictCityMapper::from).toList();
    }

    public List<DictCountryDto> getAllDictCountries() {
        return dictCountryRepository.findAll().stream().map(dictCountryMapper::from).toList();
    }
}