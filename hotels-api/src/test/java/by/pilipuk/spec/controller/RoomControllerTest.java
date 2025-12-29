package by.pilipuk.spec.controller;

import by.pilipuk.environment.service.RoomCreationTestService;
import by.pilipuk.environment.service.DBTruncateTestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

@DisplayName("Test all methods from RoomController.class")
class RoomControllerTest extends BaseControllerTest {

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
        Map<String, String> queryParams = Map.of(
                "page", "0",
                "size", "20"
        );

        performPostRequest("/v1/rooms/search",
                creationTestService.createRoomRequestDto(),
                creationTestService.createRoomPageDto(),
                queryParams);
    }

    @Test
    void getRoomById() {
        performGetRequest("/v1/rooms/{id}", 1, creationTestService.createRoomDto());
    }
}