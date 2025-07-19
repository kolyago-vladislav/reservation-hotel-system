package by.pilipuk.controller;

import by.pilipuk.entity.Hotel;
import by.pilipuk.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {

    HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return this.hotelService.getAllHotels();
    }
}
