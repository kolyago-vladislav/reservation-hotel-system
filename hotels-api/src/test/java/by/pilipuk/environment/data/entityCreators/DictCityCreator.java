package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.DictCity;
import by.pilipuk.repository.DictCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DictCityCreator {

    private final DictCityRepository dictCityRepository;

    public DictCity createDictCity() {
        DictCity dictCity = new DictCity()
        .setCity("Minsk")
        .setActive(true)
        .setCreated(Instant.parse("2025-05-14T19:47:15Z"))
        .setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));

        return dictCityRepository.save(dictCity);
    }
}