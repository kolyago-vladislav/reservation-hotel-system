package by.pilipuk.service;

import by.pilipuk.dto.DictCityDto;
import by.pilipuk.dto.DictCountryDto;
import by.pilipuk.dto.DictRoomTypeCountDto;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelSearchCriteria;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.PageHotelDto;
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
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

import org.mapstruct.AfterMapping;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;
    private final DictCityMapper dictCityMapper;
    private final DictCountryMapper dictCountryMapper;
    private final RoomTypeMapper roomTypeMapper;

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final DictCityRepository dictCityRepository;
    private final DictCountryRepository dictCountryRepository;

    //Перепиши на var
    public PageHotelDto getAllHotels(HotelSearchCriteria filterCriteria, Pageable pageable) {
        var spec = buildSpecification(filterCriteria);

//        всё в маппер
//        var countRoomTypes = getRoomTypeCountMap();
//
//        hotelDtos.forEach(hotelDto -> hotelDto.setDictRoomTypeCountDto(countRoomTypes.get(hotelDto.getId())));
//
//        //в маппер
//        PageHotelDto pageHotelDto = new PageHotelDto();
//        pageHotelDto.setContent(hotelDtos.getContent());
//        pageHotelDto.setTotalElements(hotelDtos.getTotalElements());
//        pageHotelDto.setTotalPages(hotelDtos.getTotalPages());
//        pageHotelDto.setSize(hotelDtos.getSize());

        return hotelRepository.findAll(spec, pageable)
            .map(hotelMapper::from);
    }

    public HotelDto getHotelById(Long hotelId) {
        var hotel = hotelRepository.findByIdOrThrow(hotelId);
        return hotelMapper.from(hotel);

    }

    @Transactional
    public void createHotel(HotelWriteDto hotelWriteDto) {
        var hotel = hotelMapper.to(hotelWriteDto);

//        @AfterMapping в маппере RooomMapper
//        Set<Room> rooms = hotel.getRooms();
//        if (rooms != null) {
//            for (Room room : rooms) {
//                room.setHotel(hotel);
//            }
//        }

        hotelRepository.save(hotel);
    }

    private Map<Long, List<DictRoomTypeCountDto>> getRoomTypeCountMap() {
        return roomRepository.findRoomTypeCountsByHotel()
            .stream()
            .collect(groupingBy(RoomTypeCountProjection::hotelId, mapping(roomTypeMapper::from, Collectors.toList())));
    }


    //Сделай HotelSpecificationMapper
    private Specification<Hotel> buildSpecification(HotelSearchCriteria criteria) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();


            //если size = 1, то через LIKE, иначе по полному соответсвию
            if (isNotBlank(criteria.getHotelName())) {
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

    //Сделай HotelSpecificationMapper
    private Specification<Hotel> minRating(HotelSearchCriteria criteria) {
        return (root, query, builder) -> {

            //если size = 1, то через LIKE, иначе по полному соответсвию
            if (isNotBlank(criteria.getHotelName())) {
                predicates.add(builder.like(builder.lower(root.get("name")),
                    "%" + criteria.getHotelName().toLowerCase() + "%"));
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