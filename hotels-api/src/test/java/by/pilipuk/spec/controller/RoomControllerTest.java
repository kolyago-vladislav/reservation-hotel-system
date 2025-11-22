package by.pilipuk.spec.controller;

import by.pilipuk.controller.RoomController;
import by.pilipuk.entity.Room;
import by.pilipuk.mapper.RoomMapper;
import by.pilipuk.environment.service.RoomCreationTestService;
import by.pilipuk.environment.service.DBTruncateTestService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import by.pilipuk.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor
class RoomControllerTest {

    @Autowired
    private RoomController roomController;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private DBTruncateTestService dbTestService;

    @Autowired
    private RoomCreationTestService creationTestService;

    @PersistenceContext
    EntityManager entityManager;

    @BeforeEach
    void setUp() {
        dbTestService.truncateAllTables();
        entityManager.clear();
    }

    @Test
    void findAllFilteredRooms() {
        // given
        Room expectedRoom = creationTestService.roomCreation();
        RoomDto expectedRoomDto = roomMapper.from(expectedRoom);

        // when
        var result = roomController.getAllRooms(Collections.singletonList(expectedRoom.getRoomType().getId()), Collections.singletonList(expectedRoom.getHotel().getId()), Collections.singletonList(expectedRoom.getId()));

        // then
        assertEquals(Collections.singletonList(expectedRoomDto), result);
    }

    @Test
    void getRoomById() {
        // given
        RoomDto expectedRoomDto = creationTestService.createRoomDto();

        // when
        var result = roomController.getRoomById(expectedRoomDto.getId());

        // then
        assertEquals(expectedRoomDto, result);

    }
}