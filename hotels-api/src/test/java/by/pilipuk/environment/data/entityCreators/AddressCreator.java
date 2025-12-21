package by.pilipuk.environment.data.entityCreators;

import by.pilipuk.entity.Address;
import by.pilipuk.entity.City;
import by.pilipuk.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressCreator {

    private final AddressRepository addressRepository;

    public Address createAddress(City city) {

        Address address = new Address()
                .setCity(city)
                .setStreet("Lira")
                .setHouseNumber("9a");

        return addressRepository.save(address);
    }
}
