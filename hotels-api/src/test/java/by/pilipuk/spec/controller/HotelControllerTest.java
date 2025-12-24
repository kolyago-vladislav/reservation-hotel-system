package by.pilipuk.spec.controller;

import by.pilipuk.dto.HotelRequestDto;
import by.pilipuk.environment.service.DBTruncateTestService;
import by.pilipuk.environment.service.HotelCreationTestService;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
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
@RequiredArgsConstructor
@AutoConfigureMockMvc
@DisplayName("Test all methods from HotelController.class")
class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DBTruncateTestService dbTestService;

    @Autowired
    private HotelCreationTestService creationHotelTestService;

    @BeforeEach
    void setUp() {
        dbTestService.truncateAllTables();
    }

    @Test
    void getHotels() {
        // given
        var expectedHotelPageDto = creationHotelTestService.createHotelPageDto();

        var hotelRequestDto = new HotelRequestDto();
        hotelRequestDto.setNames(Collections.singletonList("My test hotel"));
        hotelRequestDto.setCityIds(List.of(1L));
        hotelRequestDto.setRatingFrom(1);
        hotelRequestDto.setRatingTo(5);

        String jsonHotelRequestDto;
        String expectedJsonHotelPageDto;
        try {
            var objectMapper = new ObjectMapper();
            jsonHotelRequestDto = objectMapper.writeValueAsString(hotelRequestDto);
            expectedJsonHotelPageDto = objectMapper.writeValueAsString(expectedHotelPageDto);
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }

        var requestBuilder = MockMvcRequestBuilders.post("/v1/hotels/search")
                .queryParam("page", "0")
                .queryParam("size", "20")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonHotelRequestDto);

        // when
        try {
            mockMvc.perform(requestBuilder)

        // then
                    .andExpectAll(status().isOk(),
                            content().contentType(MediaType.APPLICATION_JSON),
                            content().json(expectedJsonHotelPageDto)
                    );
        } catch (Exception e) {
            fail("Error executing request perform by mockMvc: " + e.getMessage());
        }
    }

    @Test
    void addHotel() {
        // given
        String jsonHotelWriteDto;
        try {
            jsonHotelWriteDto = new ObjectMapper().writeValueAsString(creationHotelTestService.createHotelWriteDto());
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }

        var requestBuilder = MockMvcRequestBuilders.post("/v1/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonHotelWriteDto);

        // when
        try {
            mockMvc.perform(requestBuilder)

        // then
                    .andExpectAll(status().isCreated());
        } catch (Exception e) {
            fail("Error executing request perform by mockMvc: " + e.getMessage());
        }
    }

    @Test
    void getHotelById() {
        // given
        String expectedJson;
        try {
            expectedJson = new ObjectMapper().writeValueAsString(creationHotelTestService.createHotelDto());
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }

        var requestBuilder = MockMvcRequestBuilders.get("/v1/hotels/{id}", 1);

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