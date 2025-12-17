package by.pilipuk.mapper;

import by.pilipuk.dto.DictRoomTypeCountWriteDto;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.entity.*;
import by.pilipuk.repository.DictRoomTypeRepository;
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

    private DictRoomTypeRepository roomTypeRepository;

    @Mapping(target = "dictRoomTypeCountDto", ignore = true)
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
    @Mapping(target = "rooms", source = "dictRoomTypeCountWriteDto")
    public abstract Hotel to(HotelWriteDto hotelWriteDto);

    protected Set<Room> toSet(List<DictRoomTypeCountWriteDto> listRoomTypeCountWriteDto) {
        if (listRoomTypeCountWriteDto == null || listRoomTypeCountWriteDto.isEmpty()) {
            return null;
        } else {

            var rooms = new HashSet<Room>();

            for (var countDto : listRoomTypeCountWriteDto) {
                String roomType = countDto.getDictRoomType();
                Long count = countDto.getCount();

                if (roomType != null && count != null && count > 0) {
                    for (int i = 0; i < count; i++) {
                        Room newRoom = new Room()
                                .setDictRoomType(toRoomType(roomType))
                                .setDescription("Autogenerate");

                        rooms.add(newRoom);
                    }
                }
            }
            return rooms;
        }
    }

    protected DictRoomType toRoomType(String roomTypeName) {
        return roomTypeRepository.findByName(roomTypeName)
                .orElseGet(() -> {
                    DictRoomType newRoomType = new DictRoomType()
                            .setName(roomTypeName);
                    return roomTypeRepository.saveAndFlush(newRoomType);
                });
    }

}