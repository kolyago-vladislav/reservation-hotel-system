package by.pilipuk.controller;

import by.pilipuk.api.HotelApi;
import by.pilipuk.dto.*;
import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelApi {

    private final HotelService hotelService;

    @Override
    public void addHotel(HotelWriteDto hotelWriteDto) {
        hotelService.addHotel(hotelWriteDto);
    }

    @Override
    public PageHotelDto getHotels(HotelSearchCriteria filterCriteria, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        return hotelService.getAllHotels(filterCriteria, pageable);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        return hotelService.getHotelById(id);
    }

    @Override
    public List<DictCityDto> getAllDictCities() {
        return hotelService.getAllDictCities();
    }

    @Override
    public List<DictCountryDto> getAllDictCountries() {
        return hotelService.getAllDictCountries();
    }

}