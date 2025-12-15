package by.pilipuk.mapper;

import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.AddressWriteDto;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.DictCountry;

import lombok.Setter;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.beans.factory.annotation.Autowired;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(
    componentModel = SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
@Setter(onMethod_ = @Autowired)
public abstract class AddressMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "street", source = "street")
    @Mapping(target = "houseNumber", source = "houseNumber")
    @Mapping(target = "country", source = "dictCountry.country")
    @Mapping(target = "city", source = "dictCity.city")
    public abstract AddressDto from(Address address);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "street", source = "street")
    @Mapping(target = "houseNumber", source = "houseNumber")
    @Mapping(target = "dictCountry", source = "country")
    @Mapping(target = "dictCity", source = "city")
    public abstract Address to(AddressWriteDto addressWriteDto);

    //вынести в отдельный маппер

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract DictCity toCity(String city);

    //вынести в отдельный маппер

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract DictCountry toCountry(String country);

}