package by.pilipuk.controller;

import by.pilipuk.api.RoomApi;
import by.pilipuk.dto.DictRoomTypeDto;
import by.pilipuk.dto.RoomDto;
import by.pilipuk.service.RoomService;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomApi {

    private final RoomService roomService;

    @Override
    public RoomDto getRoomById(Long id) {
        return roomService.getRoomById(id);
    }

    //RoomRequestDto
    @Override
    public List<RoomDto> getAllRooms(
            List<Long> roomTypeIds,
            List<Long> hotelIds,
            List<Long> roomIds
    ) {
        return roomService.findAllFilteredRooms(roomTypeIds, hotelIds, roomIds);
    }

    //отдельный контроллер
    @Override
    public List<DictRoomTypeDto> getAllDictRoomTypes() {
        return roomService.getAllDictRoomTypes();
    }
}