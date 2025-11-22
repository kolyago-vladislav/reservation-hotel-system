package by.pilipuk.controller;

import by.pilipuk.service.RoomService;
import lombok.RequiredArgsConstructor;
import by.pilipuk.api.RoomsApi;
import by.pilipuk.dto.RoomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoomController implements RoomsApi {

    private final RoomService roomService;
    @Override
    public ResponseEntity<RoomDto> getRoomById(Long id) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<RoomDto>> getAllRooms(
            List<Long> roomTypes,
            List<Long> hotelIds,
            List<Long> roomIds
    ) {
        List<RoomDto> rooms = roomService.findAllFilteredRooms(roomTypes, hotelIds, roomIds);
        return ResponseEntity.ok(rooms);
    }

//    @GetMapping("/rooms/{id}")
//    public Optional<RoomDto> getRoomById(@PathVariable("id") Long id) {
//        return roomService.getRoomById(id);
//    }
//
//    @GetMapping("/rooms")
//    public List<RoomDto> getAllRooms(
//            @RequestParam(value = "room_types", required = false) List<Long> roomTypeIds,
//            @RequestParam(value = "hotel_ids", required = false) List<Long> hotelIds,
//            @RequestParam(value = "room_ids", required = false) List<Long> roomIds
//    ) {
//        return roomService.findAllFilteredRooms(roomTypeIds, hotelIds, roomIds);
//    }

}