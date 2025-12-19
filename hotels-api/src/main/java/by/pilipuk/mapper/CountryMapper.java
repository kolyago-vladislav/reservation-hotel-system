package by.pilipuk.mapper;

import by.pilipuk.dto.CountryDto;
import by.pilipuk.entity.Country;
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
public abstract class CountryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract Country toCountry(String country);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "country", source = "name")
    public abstract CountryDto from(Country dictCountry);

}