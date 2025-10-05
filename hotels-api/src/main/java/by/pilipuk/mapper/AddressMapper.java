package by.pilipuk.mapper;

import by.pilipuk.entity.Address;
import by.pilipuk.dto.dto.AddressDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class AddressMapper {

    @Named("fromAddress")
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "street", target = "street"),
            @Mapping(source = "houseNumber", target = "houseNumber"),
            @Mapping(source = "dictCountry.country", target = "country"),
            @Mapping(source = "dictCity.city", target = "city")
    })
    public abstract AddressDto from(Address address);

}