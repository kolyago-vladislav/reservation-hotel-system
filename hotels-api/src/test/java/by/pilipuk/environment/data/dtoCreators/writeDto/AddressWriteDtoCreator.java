package by.pilipuk.environment.data.dtoCreators.writeDto;

import by.pilipuk.dto.AddressWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressWriteDtoCreator {

    public AddressWriteDto createAddressWriteDto() {
        return new AddressWriteDto()
            .cityId(1L)
            .street("Mira")
            .houseNumber("7a");
    }

}