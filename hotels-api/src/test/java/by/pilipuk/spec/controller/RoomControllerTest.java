package by.pilipuk.spec.controller;

import by.pilipuk.dto.RoomRequestDto;
import by.pilipuk.environment.service.RoomCreationTestService;
import by.pilipuk.environment.service.DBTruncateTestService;
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
import java.util.List;
import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RequiredArgsConstructor
@AutoConfigureMockMvc
@DisplayName("Test all methods from RoomController.class")
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DBTruncateTestService dbTestService;

    @Autowired
    private RoomCreationTestService creationTestService;

    @BeforeEach
    void setUp() {
        dbTestService.truncateAllTables();
    }

    @Test
    void getRooms() {
        // given
        var expectedRoomPageDto = creationTestService.createRoomPageDto();

        var roomRequestDto = new RoomRequestDto();
        roomRequestDto.setRoomIds(List.of(1L));
        roomRequestDto.setRoomTypeIds(List.of(1L));
        roomRequestDto.setHotelIds(List.of(1L));

        String jsonRoomRequestDto;
        String expectedJson;
        try {
            var objectMapper = new ObjectMapper();
            jsonRoomRequestDto = objectMapper.writeValueAsString(roomRequestDto);
            expectedJson = objectMapper.writeValueAsString(expectedRoomPageDto);
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }

        var requestBuilder = MockMvcRequestBuilders.post("/v1/rooms/search")
                .queryParam("page", "0")
                .queryParam("size", "20")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRoomRequestDto);

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
    void getRoomById() {
        // given
        String expectedJson;
        try {
            expectedJson = new ObjectMapper().writeValueAsString(creationTestService.createRoomDto());
        } catch (JsonProcessingException e) {
            fail("Failed to prepare expected JSON: " + e.getMessage());
            return;
        }

        var requestBuilder = MockMvcRequestBuilders.get("/v1/rooms/{id}", 1);

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