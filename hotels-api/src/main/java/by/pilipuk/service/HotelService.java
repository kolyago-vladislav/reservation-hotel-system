package by.pilipuk.service;

import by.pilipuk.entity.Hotel;
import by.pilipuk.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }
}
