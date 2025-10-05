//package by.pilipuk.environment.service;
//
//import by.pilipuk.environment.data.DtoCreators;
//import by.pilipuk.dto.AddressDto;
//import by.pilipuk.dto.DictCityDto;
//import by.pilipuk.dto.DictCountryDto;
//import by.pilipuk.dto.RoomDto;
//import by.pilipuk.dto.RoomTypeDto;
//import by.pilipuk.dto.HotelDto;
//import by.pilipuk.entity.Address;
//import by.pilipuk.entity.DictCity;
//import by.pilipuk.entity.DictCountry;
//import by.pilipuk.entity.Room;
//import by.pilipuk.entity.RoomType;
//import by.pilipuk.entity.Hotel;
//import by.pilipuk.mappers.AddressMapper;
//import by.pilipuk.mappers.DictCityMapper;
//import by.pilipuk.mappers.DictCountryMapper;
//import by.pilipuk.mappers.RoomMapper;
//import by.pilipuk.mappers.RoomTypeMapper;
//import by.pilipuk.mappers.HotelMapper;
//import by.pilipuk.repository.AddressRepository;
//import by.pilipuk.repository.DictCityRepository;
//import by.pilipuk.repository.DictCountryRepository;
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
//    private final DictCountryMapper dictCountryMapper;
//    private final DictCityMapper dictCityMapper;
//    private final AddressMapper addressMapper;
//    private final RoomTypeMapper roomTypeMapper;
//    private final HotelMapper hotelMapper;
//    private final RoomMapper roomMapper;
//    private final DictCountryRepository dictCountryRepository;
//    private final DictCityRepository dictCityRepository;
//    private final AddressRepository addressRepository;
//    private final RoomTypeRepository roomTypeRepository;
//    private final HotelRepository hotelRepository;
//    private final RoomRepository roomRepository;
//    private final DtoCreators dtoCreators;
//
//    public RoomDto createRoomDto() {
//
//        DictCountryDto dictCountryDto = dtoCreators.country.createDictCountryDto();
//        DictCountry dictCountry = dictCountryRepository.save(dictCountryMapper.toEntity(dictCountryDto));
//
//        DictCityDto dictCityDto = dtoCreators.city.createDictCityDto();
//        DictCity dictCity = dictCityRepository.save(dictCityMapper.toEntity(dictCityDto));
//
//        AddressDto addressDto = dtoCreators.address.createAddressDto(dictCountry, dictCity);
//        Address address = addressRepository.save(addressMapper.toEntity(addressDto));
//
//        RoomTypeDto roomTypeDto = dtoCreators.roomType.createRoomTypeDto();
//        RoomType roomType = roomTypeRepository.save(roomTypeMapper.toEntity(roomTypeDto));
//
//        HotelDto hotelDto = dtoCreators.hotel.createHotelDto(address);
//        Hotel hotel = hotelRepository.save(hotelMapper.toEntity(hotelDto));
//
//        RoomDto roomDto = dtoCreators.room.createRoomDto(roomType, hotel);
//        Room room = roomRepository.save(roomMapper.toEntity(roomDto));
//
//        return roomMapper.toDto(room);
//    }
//}