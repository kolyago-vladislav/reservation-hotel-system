package by.pilipuk.controller;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;
import by.pilipuk.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/rooms")
    public List<RoomDto> getAllRooms(@RequestParam(value = "room_types", required = false) List<Long> roomTypeIds,
                                  @RequestParam(value = "hotel_ids", required = false) List<Long> hotelIds,
                                  @RequestParam(value = "room_ids", required = false) List<Long> roomIds) {
        List<RoomDto> filteredRooms = this.roomService.findAllFilteredRooms(roomTypeIds, hotelIds, roomIds);
        return filteredRooms;
    }

    @GetMapping("/rooms/{id}")
    public Optional<RoomDto> getRoomById(@PathVariable("id") Long id) {
        return this.roomService.getRoomById(id);
    }

}