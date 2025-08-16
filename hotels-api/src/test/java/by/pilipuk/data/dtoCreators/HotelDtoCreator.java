package by.pilipuk.data.dtoCreators;

import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.entity.Address;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class HotelDtoCreator {

    public HotelDto createHotelDto(Address address) {
        return new HotelDto(
                null,
                "My test hotel",
                (short) 5,
                address,
                true,
                Instant.parse("2025-05-14T19:47:15Z"),
                Instant.parse("2025-05-14T19:47:15.000Z")
        );
    }
}