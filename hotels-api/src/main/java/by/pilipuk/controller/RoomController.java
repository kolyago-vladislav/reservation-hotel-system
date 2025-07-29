package by.pilipuk.controller;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/rooms/{id}")
    public Optional<RoomDto> getRoomById(@PathVariable("id") Long id) {
        return this.roomService.getRoomById(id);
    }

}