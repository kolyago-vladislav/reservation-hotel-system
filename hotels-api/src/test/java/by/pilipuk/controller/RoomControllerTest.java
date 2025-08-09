package by.pilipuk.controller;

import by.pilipuk.entity.DictCountry;
import by.pilipuk.entity.DictCity;
import by.pilipuk.entity.Address;
import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.Room;
import by.pilipuk.entity.RoomType;
import by.pilipuk.mappers.RoomMapper;
import by.pilipuk.repository.DictCountryRepository;
import by.pilipuk.repository.DictCityRepository;
import by.pilipuk.repository.AddressRepository;
import by.pilipuk.repository.HotelRepository;
import by.pilipuk.repository.RoomRepository;
import by.pilipuk.repository.RoomTypeRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.Instant;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Transactional
@SpringBootTest
class RoomControllerTest {

    @Autowired
    private RoomController roomController;

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Autowired
    private DictCityRepository dictCityRepository;

    @Autowired
    private DictCountryRepository dictCountryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RoomMapper roomMapper;

    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    void cleanDatabase() {
        entityManager.createNativeQuery(
                """
                        TRUNCATE TABLE hotel.rooms RESTART IDENTITY CASCADE;
                        TRUNCATE TABLE hotel.hotels RESTART IDENTITY CASCADE;
                        TRUNCATE TABLE hotel.addresses RESTART IDENTITY CASCADE;
                        TRUNCATE TABLE hotel.dict_cities RESTART IDENTITY CASCADE;
                        TRUNCATE TABLE hotel.dict_countries RESTART IDENTITY CASCADE;
                        TRUNCATE TABLE hotel.room_types RESTART IDENTITY CASCADE;
                        """
        ).executeUpdate();
    }

    @Test
    void findAllFilteredRooms() {
        // given
        RoomType roomType1 = new RoomType();
        roomType1.setRoomType("Standard1");
        roomType1.setActive(true);
        roomType1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        roomType1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        RoomType savedRoomType = roomTypeRepository.save(roomType1);

        DictCountry dictCountry1 = new DictCountry();
        dictCountry1.setCountry("Belarus");
        dictCountry1.setActive(true);
        dictCountry1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        dictCountry1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        DictCountry savedDictCountry = dictCountryRepository.save(dictCountry1);

        DictCity dictCity1 = new DictCity();
        dictCity1.setDictCountry(savedDictCountry);
        dictCity1.setCity("Minsk");
        dictCity1.setActive(true);
        dictCity1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        dictCity1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        DictCity savedDictCity = dictCityRepository.save(dictCity1);

        Address address1 = new Address();
        address1.setDictCity(savedDictCity);
        address1.setDictCountry(savedDictCountry);
        address1.setStreet("Gogolya");
        address1.setHouseNumber("9a");
        address1.setActive(true);
        address1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        address1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        Address savedAddress = addressRepository.save(address1);

        Hotel hotel1 = new Hotel();
        hotel1.setName("My test hotel");
        hotel1.setRating((short) 5);
        hotel1.setAddress(savedAddress);
        hotel1.setActive(true);
        hotel1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        hotel1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        Hotel savedHotel = hotelRepository.save(hotel1);

        Room room1 = new Room();
        room1.setRoomType(savedRoomType);
        room1.setHotel(savedHotel);
        room1.setDescription("First test room");
        room1.setActive(true);
        room1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        room1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        Room savedRoom = roomRepository.save(room1);

        // when
        var result = roomController.getAllRooms(Collections.singletonList(savedRoomType.getId()), Collections.singletonList(savedHotel.getId()), Collections.singletonList(savedRoom.getId()));

        // then
        assertEquals(Collections.singletonList(roomMapper.toDto(savedRoom)), result);
    }

    @Test
    void getRoomById() {
        // given
        RoomType roomType1 = new RoomType();
        roomType1.setRoomType("Standard1");
        roomType1.setActive(true);
        roomType1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        roomType1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        RoomType savedRoomType = roomTypeRepository.save(roomType1);

        DictCountry dictCountry1 = new DictCountry();
        dictCountry1.setCountry("Belarus");
        dictCountry1.setActive(true);
        dictCountry1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        dictCountry1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        DictCountry savedDictCountry = dictCountryRepository.save(dictCountry1);

        DictCity dictCity1 = new DictCity();
        dictCity1.setDictCountry(savedDictCountry);
        dictCity1.setCity("Minsk");
        dictCity1.setActive(true);
        dictCity1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        dictCity1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        DictCity savedDictCity = dictCityRepository.save(dictCity1);

        Address address1 = new Address();
        address1.setDictCity(savedDictCity);
        address1.setDictCountry(savedDictCountry);
        address1.setStreet("Gogolya");
        address1.setHouseNumber("9a");
        address1.setActive(true);
        address1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        address1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        Address savedAddress = addressRepository.save(address1);

        Hotel hotel1 = new Hotel();
        hotel1.setName("My test hotel");
        hotel1.setRating((short) 5);
        hotel1.setAddress(savedAddress);
        hotel1.setActive(true);
        hotel1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        hotel1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        Hotel savedHotel = hotelRepository.save(hotel1);

        Room room1 = new Room();
        room1.setRoomType(savedRoomType);
        room1.setHotel(savedHotel);
        room1.setDescription("First test room");
        room1.setActive(true);
        room1.setCreated(Instant.parse("2025-05-14T19:47:15Z"));
        room1.setUpdated(Instant.parse("2025-05-14T19:47:15.000Z"));
        Room savedRoom = roomRepository.save(room1);

        // when
        var result = roomController.getRoomById(savedRoom.getId());

        // then
        assertEquals(roomMapper.toDto(savedRoom), result.orElseThrow());

    }
}