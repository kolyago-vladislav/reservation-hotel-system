package by.pilipuk.spec.controller;

import by.pilipuk.controller.RoomController;
import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;
import by.pilipuk.mappers.RoomMapper;
import by.pilipuk.environment.service.CascadeRoomCreationTestService;
import by.pilipuk.environment.service.DBTruncateTestService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    private CascadeRoomCreationTestService creationTestService;

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
        RoomDto expectedRoomDto = creationTestService.createRoomDto();
        Room expectedRoom = roomMapper.toEntity(expectedRoomDto);

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
        var result = roomController.getRoomById(roomMapper.toEntity(expectedRoomDto).getId());

        // then
        assertEquals(expectedRoomDto, result.orElseThrow());

    }
}