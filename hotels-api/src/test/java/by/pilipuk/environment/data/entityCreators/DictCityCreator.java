package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.City;
import by.pilipuk.repository.DictCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DictCityCreator {

    private final DictCityRepository dictCityRepository;

    public City createDictCity() {
        City city = new City()
        .setName("Praga");

        return dictCityRepository.save(city);
    }
}