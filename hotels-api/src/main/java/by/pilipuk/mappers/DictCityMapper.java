package by.pilipuk.mappers;

import by.pilipuk.dto.DictCityDto;
import by.pilipuk.entity.DictCity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DictCityMapper {

    public abstract DictCityDto toDto(DictCity dictCity);

    public abstract DictCity toEntity(DictCityDto dictCityDto);
}
