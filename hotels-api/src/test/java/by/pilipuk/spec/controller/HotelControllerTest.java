package by.pilipuk.spec.controller;

import by.pilipuk.dto.HotelRequestDto;
import by.pilipuk.environment.service.DBTruncateTestService;
import by.pilipuk.environment.service.HotelCreationTestService;
import java.util.Collections;
import java.util.List;
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
    void getHotels() throws Exception {
        // given
        creationHotelTestService.createHotelDto();

        var hotelRequestDto = new HotelRequestDto();
        hotelRequestDto.setNames(Collections.singletonList("My test hotel"));
        hotelRequestDto.setCityIds(List.of(1L));
        hotelRequestDto.setRatingFrom(1);
        hotelRequestDto.setRatingTo(5);

        var jsonHotelRequestDto = new ObjectMapper().writeValueAsString(hotelRequestDto);

        var requestBuilder = MockMvcRequestBuilders.post("/v1/hotels/search")
                .queryParam("page", "0")
                .queryParam("size", "20")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonHotelRequestDto);

        // when
        mockMvc.perform(requestBuilder)

        // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.totalCount").value(1),
                        jsonPath("$.totalPages").value(1),
                        jsonPath("$.items[*].id").value(1),
                        jsonPath("$.items[*].name").value("My test hotel")
                );
    }

    @Test
    void addHotel() throws Exception {
        // given
        String jsonHotelWriteDto = new ObjectMapper().writeValueAsString(creationHotelTestService.createHotelWriteDto());

        var requestBuilder = MockMvcRequestBuilders.post("/v1/hotels")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonHotelWriteDto);

        // when
        mockMvc.perform(requestBuilder)

        // then
                .andExpectAll(status().isCreated());
    }

    @Test
    void getHotelById() throws Exception {
        // given
        creationHotelTestService.createHotelDto();

        var requestBuilder = MockMvcRequestBuilders.get("/v1/hotels/{id}", 1);

        // when
        mockMvc.perform(requestBuilder)

        // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.id").value(1),
                        jsonPath("$.name").value("My test hotel")
                );
    }
}