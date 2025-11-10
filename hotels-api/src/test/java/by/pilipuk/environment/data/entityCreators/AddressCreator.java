package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Address;
import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;
import by.pilipuk.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class AddressCreator {

    private final AddressRepository addressRepository;

    public Address createAddress(DictCountry country, DictCity city) {

        Address address = new Address();
        address.setDictCountry(country);
        address.setDictCity(city);
        address.setStreet("Mira");
        address.setHouseNumber("7a");
        address.setActive(true);
        address.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        address.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));

        return addressRepository.save(address);
    }
}
