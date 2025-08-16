package by.pilipuk.mappers;

import by.pilipuk.dto.AddressDto;
import by.pilipuk.entity.Address;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class AddressMapper {

    public abstract AddressDto toDto(Address address);

    public abstract Address toEntity(AddressDto addressDto);
}
