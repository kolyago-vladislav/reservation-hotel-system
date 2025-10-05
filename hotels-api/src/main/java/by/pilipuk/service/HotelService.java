package by.pilipuk.service;

import by.pilipuk.dto.dto.HotelDto;
import by.pilipuk.dto.writeDto.HotelWriteDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;
    private final HotelRepository hotelRepository;

    public List<HotelDto> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(hotelMapper::toDto)
                .toList();
    }

    public void addHotel(HotelWriteDto hotelWriteDto) {
        Hotel hotel = hotelMapper.toEntity(hotelWriteDto);
        hotelRepository.save(hotel);
    }
}