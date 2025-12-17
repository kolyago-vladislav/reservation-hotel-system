package by.pilipuk.controller;

import by.pilipuk.api.RoomApi;
import by.pilipuk.dto.DictRoomTypeDto;
import by.pilipuk.service.RoomService;
import lombok.RequiredArgsConstructor;
import by.pilipuk.dto.RoomDto;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService roomService;
    @Override
    public RoomDto getRoomById(Long id) {
        return roomService.getRoomById(id)
                .orElse(null);
    }

    @Override
    public List<RoomDto> getAllRooms(
            List<Long> roomTypeIds,
            List<Long> hotelIds,
            List<Long> roomIds
    ) {
        return roomService.findAllFilteredRooms(roomTypeIds, hotelIds, roomIds);
    }

    @Override
    public List<DictRoomTypeDto> getAllDictRoomTypes() {
        return roomService.getAllDictRoomTypes();
    }
}