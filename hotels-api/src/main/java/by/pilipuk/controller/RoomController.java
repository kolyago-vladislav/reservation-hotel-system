package by.pilipuk.controller;

import by.pilipuk.api.RoomApi;
import by.pilipuk.dto.*;
import by.pilipuk.service.RoomService;
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

    @Override
    public RoomPageDto getRooms(RoomRequestDto roomRequestDto, Integer page, Integer size) {

        return roomService.getAllRooms(roomRequestDto, page, size);
    }

}