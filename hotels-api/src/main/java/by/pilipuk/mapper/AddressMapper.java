package by.pilipuk.mapper;

import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.AddressWriteDto;
import by.pilipuk.entity.Address;

import lombok.Setter;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
        componentModel = SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {DictCountryMapper.class, DictCityMapper.class}
)
@Setter(onMethod_ = @Autowired)
public abstract class AddressMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "houseNumber", source = "houseNumber")
    @Mapping(target = "country", source = "dictCountry.name")
    @Mapping(target = "city", source = "dictCity.name")
    public abstract AddressDto from(Address address);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "street", source = "street")
    @Mapping(target = "houseNumber", source = "houseNumber")
    @Mapping(target = "dictCountry.name", source = "country")
    @Mapping(target = "dictCity.name", source = "city")
    public abstract Address to(AddressWriteDto addressWriteDto);

}