package by.pilipuk.controller;

import by.pilipuk.entity.Hotel;
import by.pilipuk.mappers.HotelMapper;
import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    private final HotelMapper hotelMapper;

    public HotelController(HotelService hotelService, HotelMapper hotelMapper) {
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return this.hotelService.getAllHotels();
    }

    @PostMapping("/hotels")
    public void addUser(@RequestBody Hotel hotel) {
        this.hotelService.createHotel(hotel);
    }
}
