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

        Hotel hotel = new Hotel()
        .setName("My test hotel")
        .setRating((short) 5)
        .setAddress(address)
        .setActive(true)
        .setCreated(Instant.parse("2025-05-14T19:47:15Z"))
        .setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));

        return hotelRepository.save(hotel);
    }
}
