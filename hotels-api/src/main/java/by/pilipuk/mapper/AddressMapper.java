package by.pilipuk.mapper;

import by.pilipuk.entity.Address;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;
import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.AddressWriteDto;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class AddressMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "street", target = "street"),
            @Mapping(source = "houseNumber", target = "houseNumber"),
            @Mapping(source = "dictCountry.country", target = "country"),
            @Mapping(source = "dictCity.city", target = "city")
    })
    public abstract AddressDto from(Address address);

    @Mappings({
            @Mapping(source = "street", target = "street"),
            @Mapping(source = "houseNumber", target = "houseNumber"),
            @Mapping(source = "country", target = "dictCountry.country"),
            @Mapping(source = "city", target = "dictCity.city")
    })
    public abstract Address to(AddressWriteDto addressWriteDto);

}