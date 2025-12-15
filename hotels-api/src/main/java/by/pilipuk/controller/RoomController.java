package by.pilipuk.controller;

import by.pilipuk.api.RoomControllerApi;
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
        return roomService.getRoomById(id)
                .orElse(null);
    }

    //findAll переделать на POST + body
    //так же обернуть
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