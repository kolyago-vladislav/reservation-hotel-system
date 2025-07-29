package by.pilipuk.service;

import by.pilipuk.entity.Hotel;
import by.pilipuk.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }

    public void createHotel(Hotel hotel) {
        this.hotelRepository.save(hotel);
    }
}