package by.pilipuk.mapper;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.dto.RoomTypeCountWriteDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.RoomType;
import by.pilipuk.repository.RoomTypeRepository;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Setter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
    componentModel = "spring",
    uses = {AddressMapper.class}
)
@Setter(onMethod_ = @Autowired)
public abstract class HotelMapper {

    private RoomTypeRepository roomTypeRepository;

    @Mapping(target = "roomTypeCountDto", ignore = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "address", source = "address")
    public abstract HotelDto from(Hotel hotel);

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
        }

        var rooms = new HashSet<Room>();

        for (var countDto : listRoomTypeCountWriteDto) {
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