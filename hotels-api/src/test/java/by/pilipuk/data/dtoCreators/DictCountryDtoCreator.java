package by.pilipuk.data.dtoCreators;

import by.pilipuk.dto.DictCountryDto;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class DictCountryDtoCreator {

    public DictCountryDto createDictCountryDto() {
        return new DictCountryDto(
                null,
                "Belarus",
                true,
                Instant.parse("2025-05-14T19:47:15Z"),
                Instant.parse("2025-05-14T19:47:15.000Z")
        );
    }
}