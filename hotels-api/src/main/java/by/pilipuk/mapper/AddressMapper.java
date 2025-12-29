package by.pilipuk.mapper;

import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.AddressWriteDto;
import by.pilipuk.entity.Address;
import lombok.Setter;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {CountryMapper.class, CityMapper.class}
)
@Setter(onMethod_ = @Autowired)
public abstract class AddressMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "houseNumber", source = "houseNumber")
    @Mapping(target = "cityId", source = "city.id")
    public abstract AddressDto from(Address address);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "street", source = "street")
    @Mapping(target = "houseNumber", source = "houseNumber")
    @Mapping(target = "city.id", source = "cityId")
    public abstract Address to(AddressWriteDto addressWriteDto);

}