package by.pilipuk.controller;

import by.pilipuk.dto.dto.HotelDto;
import by.pilipuk.dto.writeDto.HotelWriteDto;
import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/hotels")
    public List<HotelDto> getHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping("/hotels")
    public void addHotel(@RequestBody HotelWriteDto hotelWriteDto) {
        hotelService.addHotel(hotelWriteDto);
    }
}
