package by.pilipuk.environment.service;

import by.pilipuk.dto.CityDto;
import by.pilipuk.dto.CountryDto;
import by.pilipuk.dto.RoomTypeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DictionaryCreationTestService {
    public List<CityDto> createCityDtosList() {
        var city1 = new CityDto();
        city1.setId(1L);
        city1.setName("Minsk");

        var city2 = new CityDto();
        city2.setId(2L);
        city2.setName("Warsaw");

        var city3 = new CityDto();
        city3.setId(3L);
        city3.setName("Berlin");

        var city4 = new CityDto();
        city4.setId(4L);
        city4.setName("Paris");

        var city5 = new CityDto();
        city5.setId(5L);
        city5.setName("New York");

        var city6 = new CityDto();
        city6.setId(6L);
        city6.setName("Madrid");

        var city7 = new CityDto();
        city7.setId(7L);
        city7.setName("Rome");

        var city8 = new CityDto();
        city8.setId(8L);
        city8.setName("Shanghai");

        var city9 = new CityDto();
        city9.setId(9L);
        city9.setName("Rio de Janeiro");

        var city10 = new CityDto();
        city10.setId(10L);
        city10.setName("Mexico City");

        var city11 = new CityDto();
        city11.setId(11L);
        city11.setName("Tokyo");

        var city12 = new CityDto();
        city12.setId(12L);
        city12.setName("Toronto");

        var city13 = new CityDto();
        city13.setId(13L);
        city13.setName("Sydney");

        var city14 = new CityDto();
        city14.setId(14L);
        city14.setName("Mumbai");

        var city15 = new CityDto();
        city15.setId(15L);
        city15.setName("Moscow");

        var city16 = new CityDto();
        city16.setId(16L);
        city16.setName("London");

        var city17 = new CityDto();
        city17.setId(17L);
        city17.setName("Cairo");

        var city18 = new CityDto();
        city18.setId(18L);
        city18.setName("Istanbul");

        var city19 = new CityDto();
        city19.setId(19L);
        city19.setName("Buenos Aires");

        var city20 = new CityDto();
        city20.setId(20L);
        city20.setName("Seoul");

        return List.of(
                city1, city2, city3, city4, city5, city6, city7, city8, city9, city10,
                city11, city12, city13, city14, city15, city16, city17, city18, city19, city20
        );
    }

    public List<CountryDto> createCountryDtosList() {
        var c1 = new CountryDto();
        c1.setId(1L);
        c1.setName("Belarus");

        var c2 = new CountryDto();
        c2.setId(2L);
        c2.setName("Poland");

        var c3 = new CountryDto();
        c3.setId(3L);
        c3.setName("Germany");

        var c4 = new CountryDto();
        c4.setId(4L);
        c4.setName("France");

        var c5 = new CountryDto();
        c5.setId(5L);
        c5.setName("USA");

        var c6 = new CountryDto();
        c6.setId(6L);
        c6.setName("Spain");

        var c7 = new CountryDto();
        c7.setId(7L);
        c7.setName("Italy");

        var c8 = new CountryDto();
        c8.setId(8L);
        c8.setName("China");

        var c9 = new CountryDto();
        c9.setId(9L);
        c9.setName("Brazil");

        var c10 = new CountryDto();
        c10.setId(10L);
        c10.setName("Mexico");

        var c11 = new CountryDto();
        c11.setId(11L);
        c11.setName("Japan");

        var c12 = new CountryDto();
        c12.setId(12L);
        c12.setName("Canada");

        var c13 = new CountryDto();
        c13.setId(13L);
        c13.setName("Australia");

        var c14 = new CountryDto();
        c14.setId(14L);
        c14.setName("India");

        var c15 = new CountryDto();
        c15.setId(15L);
        c15.setName("Russia");

        var c16 = new CountryDto();
        c16.setId(16L);
        c16.setName("UK");

        var c17 = new CountryDto();
        c17.setId(17L);
        c17.setName("Egypt");

        var c18 = new CountryDto();
        c18.setId(18L);
        c18.setName("Turkey");

        var c19 = new CountryDto();
        c19.setId(19L);
        c19.setName("Argentina");

        var c20 = new CountryDto();
        c20.setId(20L);
        c20.setName("South Korea");

        return List.of(
                c1, c2, c3, c4, c5, c6, c7, c8, c9, c10,
                c11, c12, c13, c14, c15, c16, c17, c18, c19, c20
        );
    }

    public List<RoomTypeDto> createRoomTypesList() {
        var c1 = new RoomTypeDto();
        c1.setId(1L);
        c1.setName("President");

        var c2 = new RoomTypeDto();
        c2.setId(2L);
        c2.setName("Lux");

        var c3 = new RoomTypeDto();
        c3.setId(3L);
        c3.setName("Standard");

        var c4 = new RoomTypeDto();
        c4.setId(4L);
        c4.setName("Economy");

        return List.of(c1, c2, c3, c4);
    }
}
