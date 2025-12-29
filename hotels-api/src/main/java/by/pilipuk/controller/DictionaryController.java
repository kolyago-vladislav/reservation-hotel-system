package by.pilipuk.controller;

import by.pilipuk.api.DictionaryApi;
import by.pilipuk.dto.CityDto;
import by.pilipuk.dto.CountryDto;
import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.service.DictionaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DictionaryController implements DictionaryApi {

    private final DictionaryService dictionaryService;

    @Override
    public List<CityDto> getCities() {
        return dictionaryService.getAllCities();
    }

    @Override
    public List<CountryDto> getCountries() {
        return dictionaryService.getAllCountries();
    }

    @Override
    public List<RoomTypeDto> getRoomTypes() {
        return dictionaryService.getAllRoomTypes();
    }
}
