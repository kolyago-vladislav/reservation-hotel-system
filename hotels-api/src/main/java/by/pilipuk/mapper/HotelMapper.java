package by.pilipuk.mapper;

import by.pilipuk.dto.*;
import by.pilipuk.entity.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import by.pilipuk.repository.RoomRepository;
import lombok.Setter;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

@Mapper(
    componentModel = "spring",
    uses = {AddressMapper.class}
)
@Setter(onMethod_ = @Autowired)
public abstract class HotelMapper {

    private RoomTypeMapper roomTypeMapper;

    private RoomRepository roomRepository;

    @Mapping(target = "roomTypeCountDto", ignore = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "address", source = "address")
    public abstract HotelDto from(Hotel hotel);

    @AfterMapping
    protected void fillRoomTypeCounts(Hotel hotel, @MappingTarget HotelDto dto) {
        if (hotel.getRooms() == null || hotel.getRooms().isEmpty()) {
            return;
        }

        Map<RoomType, Long> mapCounts = hotel.getRooms().stream()
                .collect(Collectors.groupingBy(
                        Room::getRoomType,
                        Collectors.counting()
                ));

        List<RoomTypeCountDto> countDtos = mapCounts.entrySet().stream()
                .map(entry -> {
                    RoomTypeCountDto countDto = new RoomTypeCountDto();
                    countDto.setId(entry.getKey().getId());
                    countDto.setCount(entry.getValue().intValue());
                    return countDto;
                })
                .toList();

        dto.setRoomTypeCountDto(countDtos);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "rooms", source = "roomTypeCountWriteDto")
    public abstract Hotel to(HotelWriteDto hotelWriteDto);

    protected Set<Room> toSet(List<RoomTypeCountWriteDto> listRoomTypeCountWriteDto) {
        if (listRoomTypeCountWriteDto == null || listRoomTypeCountWriteDto.isEmpty()) {
            return null;
        } else {

            var rooms = new HashSet<Room>();

            for (var countDto : listRoomTypeCountWriteDto) {
                Long roomTypeId = countDto.getRoomTypeId();
                Long count = countDto.getCount();

                if (roomTypeId != null && count != null && count > 0) {
                    for (int i = 0; i < count; i++) {
                        Room newRoom = new Room()
                                .setRoomType(roomTypeMapper.toRoomType(roomTypeId))
                                .setDescription("Autogenerate");

                        rooms.add(newRoom);
                    }
                }
            }
            return rooms;
        }
    }

    @AfterMapping
    protected void addRooms(HotelWriteDto hotelWriteDto, @MappingTarget Hotel hotel) {
        Set<Room> rooms = hotel.getRooms();
        if (rooms != null) {
            for (Room room : rooms) {
                room.setHotel(hotel);
            }
        }
    }

    public HotelPageDto toHotelPageDto(Page<Hotel> pageHotels) {
        var countRoomTypes = roomRepository.findRoomTypeCountsByHotel()
                .stream()
                .collect(groupingBy(RoomTypeCountProjection::hotelId, mapping(roomTypeMapper::fromProjection, Collectors.toList())));

        var dto = new HotelPageDto();

        dto.setTotalCount(pageHotels.getTotalElements());
        dto.setTotalPages(pageHotels.getTotalPages());
        dto.setItems(pageHotels.getContent().stream()
                .map(this::from)
                .map(hotelDto -> {
                    hotelDto.setRoomTypeCountDto(countRoomTypes.get(hotelDto.getId()));
                    return hotelDto;
                })
                .toList());
        return dto;
    }

}