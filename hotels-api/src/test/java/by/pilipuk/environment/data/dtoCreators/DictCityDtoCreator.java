package by.pilipuk.environment.data.dtoCreators;

import by.pilipuk.dto.DictCityDto;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class DictCityDtoCreator {

    public DictCityDto createDictCityDto() {
        return new DictCityDto(
                null,
                "Minsk",
                true,
                Instant.parse("2025-05-14T19:47:15Z"),
                Instant.parse("2025-05-14T19:47:15.000Z")
        );
    }
}