package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Country;
import by.pilipuk.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DictCountryCreator {

    private final CountryRepository dictCountryRepository;

    public Country createDictCountry() {
        Country dictCountry = new Country()
        .setName("Czech Republic");

        return dictCountryRepository.save(dictCountry);
    }
}