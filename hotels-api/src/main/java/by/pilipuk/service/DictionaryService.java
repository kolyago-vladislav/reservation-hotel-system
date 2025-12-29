package by.pilipuk.service;

import by.pilipuk.dto.CityDto;
import by.pilipuk.dto.CountryDto;
import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.mapper.CityMapper;
import by.pilipuk.mapper.CountryMapper;
import by.pilipuk.mapper.RoomTypeMapper;
import by.pilipuk.repository.CityRepository;
import by.pilipuk.repository.CountryRepository;
import by.pilipuk.repository.RoomTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DictionaryService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final RoomTypeRepository roomTypeRepository;

    private final CityMapper cityMapper;
    private final CountryMapper countryMapper;
    private final RoomTypeMapper roomTypeMapper;

    public List<CityDto> getAllCities() {
        return cityRepository.findAll().stream().map(cityMapper::from).toList();
    }

    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream().map(countryMapper::from).toList();
    }

    public List<RoomTypeDto> getAllRoomTypes() {
        return roomTypeRepository.findAll().stream().map(roomTypeMapper::from).toList();
    }
}
