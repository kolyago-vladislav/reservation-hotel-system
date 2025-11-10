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
        DictCity dictCity = new DictCity();
        dictCity.setCity("Minsk");
        dictCity.setActive(true);
        dictCity.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        dictCity.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        return dictCityRepository.save(dictCity);
    }
}