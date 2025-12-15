package by.pilipuk.controller;

import by.pilipuk.api.HotelApi;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.service.HotelService;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelApi {

    private final HotelService hotelService;

    @Override
    public HotelPageDto getHotels() {
        return hotelService.getAllHotels();
    }

    @Override
    public void addHotel(HotelWriteDto hotelWriteDto) {
        hotelService.addHotel(hotelWriteDto);
    }

}