package by.pilipuk.spec.controller;

import by.pilipuk.environment.service.DBTruncateTestService;
import by.pilipuk.environment.service.HotelCreationTestService;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("Test all methods from HotelController.class")
class HotelControllerTest extends BaseControllerTest {

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
        Map<String, String> queryParams = Map.of(
                "page", "0",
                "size", "20"
        );

        performPostRequest(
                "/v1/hotels/search",
                creationHotelTestService.createHotelRequestDto(),
                creationHotelTestService.createHotelPageDto(),
                queryParams
        );
    }

    @Test
    void addHotel() {
        performPostRequest("/v1/hotels", creationHotelTestService.createHotelWriteDto());
    }

    @Test
    void getHotelById() {
        performGetRequest("/v1/hotels/{id}", 1, creationHotelTestService.createHotelDto());
    }
}