package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Address;
import by.pilipuk.entity.Hotel;
import by.pilipuk.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class HotelCreator {

    private final HotelRepository hotelRepository;

    public Hotel createHotel(Address address) {

        Hotel hotel = new Hotel();
        hotel.setName("My test hotel");
        hotel.setRating((short) 5);
        hotel.setAddress(address);
        hotel.setActive(true);
        hotel.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        hotel.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));

        return hotelRepository.save(hotel);
    }
}
