package by.pilipuk.controller;

import by.pilipuk.service.RoomService;
import lombok.RequiredArgsConstructor;
import by.pilipuk.api.RoomsApi;
import by.pilipuk.dto.RoomDto;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomsApi {

    private final RoomService roomService;
    @Override
    public RoomDto getRoomById(Long id) {
        return roomService.getRoomById(id)
                .orElse(null);
    }

    @Override
    public List<RoomDto> getAllRooms(
            List<Long> roomTypes,
            List<Long> hotelIds,
            List<Long> roomIds
    ) {
        List<RoomDto> rooms = roomService.findAllFilteredRooms(roomTypes, hotelIds, roomIds);
        return rooms;
    }

}