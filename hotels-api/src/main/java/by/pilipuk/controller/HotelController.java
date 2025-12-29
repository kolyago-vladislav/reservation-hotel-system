package by.pilipuk.controller;

import by.pilipuk.api.HotelApi;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelPageDto;
import by.pilipuk.dto.HotelRequestDto;
import by.pilipuk.dto.HotelWriteDto;
import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelApi {

    private final HotelService hotelService;

    @Override
    public void createHotel(HotelWriteDto hotelWriteDto) {
        hotelService.createHotel(hotelWriteDto);
    }

    @Override
    public HotelPageDto getHotels(HotelRequestDto hotelRequestDto, Integer page, Integer size) {

        return hotelService.getAllHotels(hotelRequestDto, page, size);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        return hotelService.getHotelById(id);
    }

}