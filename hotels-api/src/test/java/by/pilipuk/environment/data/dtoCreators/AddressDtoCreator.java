package by.pilipuk.environment.data.dtoCreators;

import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class AddressDtoCreator {

    public AddressDto createAddressDto(DictCountry dictCountry, DictCity dictCity) {
        return new AddressDto(
                null,
                "Mira",
                "7a",
                dictCountry,
                dictCity,
                true,
                Instant.parse("2025-05-14T19:47:15Z"),
                Instant.parse("2025-05-14T19:47:15.000Z")
        );
    }
}