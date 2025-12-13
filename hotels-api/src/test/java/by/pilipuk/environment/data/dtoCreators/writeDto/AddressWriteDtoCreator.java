package by.pilipuk.environment.data.dtoCreators.writeDto;

import by.pilipuk.dto.AddressWriteDto;
import by.pilipuk.entity.Address;
import by.pilipuk.mapper.AddressMapper;
import by.pilipuk.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressWriteDtoCreator {

    private final AddressMapper addressMapper;

    private final AddressRepository addressRepository;

    public AddressWriteDto createAddressWriteDto() {
        AddressWriteDto addressWriteDto = new AddressWriteDto()
                .city("Minsk")
                .country("Belarus")
                .street("Mira")
                .houseNumber("7a");

        addressRepository.save(addressMapper.to(addressWriteDto));

        return addressWriteDto;
    }

}