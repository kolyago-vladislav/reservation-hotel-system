package by.pilipuk.mapper;

import by.pilipuk.dto.DictCityDto;
import by.pilipuk.entity.City;

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
public abstract class DictCityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    public abstract City toCity(String city);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "city", source = "name")
    public abstract DictCityDto from(City city);

}