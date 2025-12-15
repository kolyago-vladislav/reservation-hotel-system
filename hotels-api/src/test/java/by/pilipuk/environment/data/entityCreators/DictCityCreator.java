package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.DictCity;
import by.pilipuk.repository.DictCityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DictCityCreator {

    private final DictCityRepository dictCityRepository;

    public DictCity createDictCity() {
        DictCity dictCity = new DictCity()
        .setCity("Praga");

        return dictCityRepository.save(dictCity);
    }
}