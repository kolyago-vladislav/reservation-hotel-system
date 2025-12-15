package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.DictCountry;
import by.pilipuk.repository.DictCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DictCountryCreator {

    private final DictCountryRepository dictCountryRepository;

    public DictCountry createDictCountry() {
        DictCountry dictCountry = new DictCountry()
        .setCountry("Czech Republic");

        return dictCountryRepository.save(dictCountry);
    }
}