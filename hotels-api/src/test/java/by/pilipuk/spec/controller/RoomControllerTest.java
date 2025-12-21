package by.pilipuk.spec.controller;

import by.pilipuk.dto.RoomRequestDto;
import by.pilipuk.environment.service.RoomCreationTestService;
import by.pilipuk.environment.service.DBTruncateTestService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
    void getRooms() throws Exception {
        // given
        creationTestService.createRoomDto();

        var roomRequestDto = new RoomRequestDto();
        roomRequestDto.setRoomIds(List.of(1L));
        roomRequestDto.setRoomTypeIds(List.of(1L));
        roomRequestDto.setHotelIds(List.of(1L));

        var jsonRoomRequestDto = new ObjectMapper().writeValueAsString(roomRequestDto);

        var requestBuilder = MockMvcRequestBuilders.post("/v1/rooms/search")
                .queryParam("page", "0")
                .queryParam("size", "20")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRoomRequestDto);

        // when
        mockMvc.perform(requestBuilder)

                // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.totalCount").value(1),
                        jsonPath("$.totalPages").value(1),
                        jsonPath("$.items[*].id").value(1),
                        jsonPath("$.items[*].roomTypeId").value(1),
                        jsonPath("$.items[*].description").value("My test room in test hotel")
                );
    }

    @Test
    void getRoomById() throws Exception {
        // given
        creationTestService.createRoomDto();

        var requestBuilder = MockMvcRequestBuilders.get("/v1/rooms/{id}", 1);

        // when
        mockMvc.perform(requestBuilder)

        // then
                .andExpectAll(status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.id").value(1),
                        jsonPath("$.roomTypeId").value(1),
                        jsonPath("$.description").value("My test room in test hotel")
                );
    }
}