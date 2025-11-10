package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.DictCountry;
import by.pilipuk.repository.DictCountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DictCountryCreator {

    private final DictCountryRepository dictCountryRepository;

    public DictCountry createDictCountry() {
        DictCountry dictCountry = new DictCountry();
        dictCountry.setCountry("Belarus");
        dictCountry.setActive(true);
        dictCountry.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        dictCountry.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        return dictCountryRepository.save(dictCountry);
    }
}