package by.pilipuk.environment.data.dtoCreators;

import by.pilipuk.dto.dto.AddressDto;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class AddressDtoCreator {

    public AddressDto createAddressDto() {
        return new AddressDto(
                null,
                "Mira",
                "7a",
                "Belarus",
                "Minsk"
        );
    }
}