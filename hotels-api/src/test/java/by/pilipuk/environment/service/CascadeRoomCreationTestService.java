//package by.pilipuk.environment.service;
//
//import by.pilipuk.environment.data.DtoCreators;
//import by.pilipuk.dto.dto.AddressDto;
//import by.pilipuk.dto.dto.RoomDto;
//import by.pilipuk.dto.dto.HotelDto;
//import by.pilipuk.entity.Address;
//import by.pilipuk.entity.Room;
//import by.pilipuk.entity.Hotel;
//import by.pilipuk.mapper.AddressMapper;
//import by.pilipuk.mapper.RoomMapper;
//import by.pilipuk.mapper.HotelMapper;
//import by.pilipuk.repository.AddressRepository;
//import by.pilipuk.repository.RoomRepository;
//import by.pilipuk.repository.RoomTypeRepository;
//import by.pilipuk.repository.HotelRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CascadeRoomCreationTestService {
//
//    private final AddressMapper addressMapper;
//    private final HotelMapper hotelMapper;
//    private final RoomMapper roomMapper;
//    private final AddressRepository addressRepository;
//    private final HotelRepository hotelRepository;
//    private final RoomRepository roomRepository;
//    private final DtoCreators dtoCreators;
//
//    public RoomDto createRoomDto() {
//
//        AddressDto addressDto = dtoCreators.address.createAddressDto();
//        Address address = addressRepository.save(addressMapper.to(addressDto));
//
//        HotelDto hotelDto = dtoCreators.hotel.createHotelDto(address, roomTypeCountDto);
//        Hotel hotel = hotelRepository.save(hotelMapper.toEntity(hotelDto));
//
//        RoomDto roomDto = dtoCreators.room.createRoomDto(roomType, hotel);
//        Room room = roomRepository.save(roomMapper.toEntity(roomDto));
//
//        return roomMapper.toDto(room);
//    }
//}