package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Address;
import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;
import by.pilipuk.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressCreator {

    private final AddressRepository addressRepository;

    public Address createAddress(DictCountry country, DictCity city) {

        Address address = new Address()
                .setDictCountry(country)
                .setDictCity(city)
                .setStreet("Lira")
                .setHouseNumber("9a");

        return addressRepository.save(address);
    }
}
