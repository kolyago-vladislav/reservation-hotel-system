package by.pilipuk.service;

import by.pilipuk.dto.HotelDto;
import by.pilipuk.entity.Hotel;
import by.pilipuk.mappers.HotelMapper;
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
        return this.hotelRepository.findAll().stream()
                .map(hotelMapper::toDto)
                .toList();
    }

    public void createHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        this.hotelRepository.save(hotel);
    }
}