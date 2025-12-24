package by.pilipuk.spec.controller;

import by.pilipuk.environment.service.DictionaryCreationTestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor
@DisplayName("Test all methods from DictionaryController.class")
public class DictionaryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DictionaryCreationTestService dictionaryCreationTestService;

    @Test
    void getCities() {
        // given
        String expectedJson;
        try {
            expectedJson = new ObjectMapper().writeValueAsString(dictionaryCreationTestService.createCityDtosList());
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }
        var requestBuilder = MockMvcRequestBuilders.get("/v1/dictionaries/cities");

        // when
        try {
            mockMvc.perform(requestBuilder)

        // then
                    .andExpectAll(status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(expectedJson)
                            );
        } catch (Exception e) {
            fail("Error executing request perform by mockMvc: " + e.getMessage());
        }
    }

    @Test
    void getCountries() {
        // given
        String expectedJson;
        try {
            expectedJson = new ObjectMapper().writeValueAsString(dictionaryCreationTestService.createCountryDtosList());
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }
        var requestBuilder = MockMvcRequestBuilders.get("/v1/dictionaries/countries");

        // when
        try {
            mockMvc.perform(requestBuilder)

        // then
                    .andExpectAll(status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(expectedJson)
                    );
        } catch (Exception e) {
            fail("Error executing request perform by mockMvc: " + e.getMessage());
        }
    }

    @Test
    void getRoomTypes() {
        // given
        String expectedJson;
        try {
            expectedJson = new ObjectMapper().writeValueAsString(dictionaryCreationTestService.createRoomTypesList());
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }
        var requestBuilder = MockMvcRequestBuilders.get("/v1/dictionaries/roomTypes");

        // when
        try {
            mockMvc.perform(requestBuilder)

        // then
                    .andExpectAll(status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(expectedJson)
                    );
        } catch (Exception e) {
            fail("Error executing request perform by mockMvc: " + e.getMessage());
        }
    }
}