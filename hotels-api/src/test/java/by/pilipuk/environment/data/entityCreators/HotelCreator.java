package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Address;
import by.pilipuk.entity.Hotel;
import by.pilipuk.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HotelCreator {

    private final HotelRepository hotelRepository;

    public Hotel createHotel(Address address) {

        Hotel hotel = new Hotel()
        .setName("My test hotel")
        .setRating((short) 5)
        .setAddress(address);

        return hotelRepository.save(hotel);
    }
}
