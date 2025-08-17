package by.pilipuk.environment.data;

import by.pilipuk.environment.data.dtoCreators.DictCityDtoCreator;
import by.pilipuk.environment.data.dtoCreators.DictCountryDtoCreator;
import by.pilipuk.environment.data.dtoCreators.AddressDtoCreator;
import by.pilipuk.environment.data.dtoCreators.RoomTypeDtoCreator;
import by.pilipuk.environment.data.dtoCreators.HotelDtoCreator;
import by.pilipuk.environment.data.dtoCreators.RoomDtoCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoCreators {

    public final DictCountryDtoCreator country;

    public final DictCityDtoCreator city;

    public final AddressDtoCreator address;

    public final RoomTypeDtoCreator roomType;

    public final HotelDtoCreator hotel;

    public final RoomDtoCreator room;

}