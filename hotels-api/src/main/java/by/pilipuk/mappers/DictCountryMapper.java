package by.pilipuk.mappers;

import by.pilipuk.dto.DictCountryDto;
import by.pilipuk.entity.DictCountry;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DictCountryMapper {

    public abstract DictCountryDto toDto(DictCountry dictCountry);

    public abstract DictCountry toEntity(DictCountryDto dictCountryDto);
}
