//package by.pilipuk.spec.controller;
//
//import by.pilipuk.controller.HotelController;
//import by.pilipuk.dto.AddressWriteDto;
//import by.pilipuk.dto.HotelDto;
//import by.pilipuk.dto.HotelWriteDto;
//import by.pilipuk.dto.RoomTypeCountWriteDto;
//import by.pilipuk.entity.Hotel;
//import by.pilipuk.environment.service.DBTruncateTestService;
//import by.pilipuk.environment.service.HotelCreationTestService;
//import by.pilipuk.mapper.HotelMapper;
//import by.pilipuk.mapper.RoomTypeMapper;
//import by.pilipuk.model.dto.RoomTypeCountProjection;
//import by.pilipuk.repository.RoomRepository;
//import java.util.Collections;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//@RequiredArgsConstructor
//class HotelControllerTest {
//
//    @Autowired
//    HotelController hotelController;
//
//    @Autowired
//    HotelMapper hotelMapper;
//
//    @Autowired
//    RoomRepository roomRepository;
//
//    @Autowired
//    RoomTypeMapper roomTypeMapper;
//
//    @Autowired
//    private DBTruncateTestService dbTestService;
//
//    @Autowired
//    private HotelCreationTestService creationHotelTestService;
//
//    @BeforeEach
//    void setUp() {
//        dbTestService.truncateAllTables();
//    }
//
//    @Test
//    void getHotels() {
//        // given
//        Hotel expectedHotel = creationHotelTestService.hotelCreation();
//        HotelDto expectedHotelDto = hotelMapper.from(expectedHotel);
//
//        // when
//        var result = hotelController.getHotels();
//
//        // then
//        assertEquals(Collections.singletonList(expectedHotelDto), result);
//    }
//
//    @Test
//    void addHotel() {
//        // given
//        HotelWriteDto expectedHotelWriteDto = creationHotelTestService.createHotelWriteDto();
//
//        // when
//        hotelController.addHotel(expectedHotelWriteDto);
//
//        HotelDto savedHotelDto = hotelController.getHotels().getLast();
//
//        var result = new HotelWriteDto()
//                .name(savedHotelDto.getName())
//                .rating(savedHotelDto.getRating())
//                .address(
//                        new AddressWriteDto()
//                                .country(savedHotelDto.getAddress().getCountry())
//                                .city(savedHotelDto.getAddress().getCity())
//                                .street(savedHotelDto.getAddress().getStreet())
//                                .houseNumber(savedHotelDto.getAddress().getHouseNumber())
//                )
//                .roomTypeCountWriteDto(savedHotelDto.getRoomTypeCountDto().stream()
//                        .map(rc -> new RoomTypeCountWriteDto()
//                                .roomType(rc.getRoomType())
//                                .count(rc.getCount())
//                        )
//                        .toList()
//                );
//
//        // then
//        assertEquals(expectedHotelWriteDto, result);
//    }
//
//    @Test
//    void getHotelsWithRoomCounts() {
//        // given
//        HotelWriteDto expectedHotelWriteDto = creationHotelTestService.createHotelWriteDto();
//        hotelController.addHotel(expectedHotelWriteDto);
//
//        HotelDto savedHotelDto = hotelController.getHotels().getLast();
//
//        List<RoomTypeCountProjection> roomCounts = roomRepository.findRoomTypeCountsByHotel();
//        savedHotelDto.setRoomTypeCountDto(Collections.singletonList(roomTypeMapper.from(roomCounts.getLast())));
//
//        // when
//        var result = hotelController.getHotelsWithRoomCounts(0, 1).getContent();
//
//        // then
//        assertEquals(Collections.singletonList(savedHotelDto), result);
//    }
//}