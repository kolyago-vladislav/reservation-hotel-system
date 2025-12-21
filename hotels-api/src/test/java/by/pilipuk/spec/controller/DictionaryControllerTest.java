package by.pilipuk.spec.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.core.IsIterableContaining.hasItems;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@DisplayName("Test all methods from DictionaryController.class")
public class DictionaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCities() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.get("/v1/dictionaries/cities");

        // when
        mockMvc.perform(requestBuilder)

                // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.length()").value(20),
                        jsonPath("$[*].name", hasItems("Minsk", "Warsaw", "Berlin", "Paris", "New York", "Madrid", "Rome", "Shanghai", "Rio de Janeiro", "Mexico City", "Tokyo", "Toronto", "Sydney", "Mumbai", "Moscow", "London", "Cairo", "Istanbul", "Buenos Aires", "Seoul")),
                        jsonPath("$[*].id", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
                );
    }

    @Test
    void getCountries() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.get("/v1/dictionaries/countries");

        // when
        mockMvc.perform(requestBuilder)

                // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.length()").value(20),
                        jsonPath("$[*].name", hasItems("Belarus", "Poland", "Germany", "France", "USA", "Spain", "Italy", "China", "Brazil", "Mexico", "Japan", "Canada", "Australia", "India", "Russia", "UK", "Egypt", "Turkey", "Argentina", "South Korea")),
                        jsonPath("$[*].id", hasItems(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
                );
    }

    @Test
    void getRoomTypes() throws Exception {
        // given
        var requestBuilder = MockMvcRequestBuilders.get("/v1/dictionaries/roomTypes");

        // when
        mockMvc.perform(requestBuilder)

                // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.length()").value(4),
                        jsonPath("$[*].name", hasItems("President", "Lux", "Standard", "Economy")),
                        jsonPath("$[*].id", hasItems(1, 2, 3, 4))
                );
    }
}