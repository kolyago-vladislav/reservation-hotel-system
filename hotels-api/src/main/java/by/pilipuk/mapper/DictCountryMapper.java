package by.pilipuk.mapper;

import by.pilipuk.dto.DictCountryDto;
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
public abstract class DictCountryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract DictCountry toCountry(String country);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "country", source = "name")
    public abstract DictCountryDto from(DictCountry dictCountry);

}