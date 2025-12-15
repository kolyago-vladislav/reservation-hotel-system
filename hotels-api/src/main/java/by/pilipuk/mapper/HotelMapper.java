package by.pilipuk.mapper;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.dto.RoomTypeCountWriteDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.RoomType;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(
    componentModel = "spring",
    uses = {AddressMapper.class}
)
@Setter(onMethod_ = @Autowired)
public abstract class HotelMapper {

    private RoomTypeRepository roomTypeRepository;

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "roomTypeCountDto", expression = "java(fromSet(hotel.getRooms()))")
    public abstract HotelDto from(Hotel hotel);

    protected List<RoomTypeCountDto> fromSet(Set<Room> rooms) {
        if (rooms == null || rooms.isEmpty()) {
            return Collections.emptyList();
        }

        return rooms.stream()
                .filter(r -> r.getRoomType() != null && r.getRoomType().getRoomType() != null)
                .collect(Collectors.groupingBy(r -> r.getRoomType().getRoomType(), Collectors.counting()))
                .entrySet().stream()
                .map(entry -> new RoomTypeCountDto()
                        .roomType(entry.getKey())
                        .count(entry.getValue().intValue()))
                .toList();
    }

    @Mapping(target = "name", source = "name")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "rooms", source = "roomTypeCountWriteDto")
    public abstract Hotel to(HotelWriteDto hotelWriteDto);

    protected Set<Room> toSet(List<RoomTypeCountWriteDto> listRoomTypeCountWriteDto) {
        if (listRoomTypeCountWriteDto == null || listRoomTypeCountWriteDto.isEmpty()) {
            return Collections.emptySet();
        }

        Set<Room> rooms = new HashSet<>();

        for (RoomTypeCountWriteDto countDto : listRoomTypeCountWriteDto) {
            String roomType = countDto.getRoomType();
            Integer count = countDto.getCount();

            if (roomType != null && count != null && count > 0) {
                for (int i = 0; i < count; i++) {
                    Room newRoom = new Room()
                            .setRoomType(toRoomType(roomType))
                            .setDescription("Autogenerate");

                    rooms.add(newRoom);
                }
            }
        }
        return rooms;
    }

    protected RoomType toRoomType(String roomTypeName) {
        return roomTypeRepository.findByRoomType(roomTypeName)
                .orElseGet(() -> {
                    RoomType newRoomType = new RoomType()
                            .setRoomType(roomTypeName);
                    return roomTypeRepository.saveAndFlush(newRoomType);
                });
    }

}