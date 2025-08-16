package by.pilipuk.service;

//import by.pilipuk.data.DtoCreators;
import by.pilipuk.data.dtoCreators.AddressDtoCreator;
import by.pilipuk.data.dtoCreators.DictCityDtoCreator;
import by.pilipuk.data.dtoCreators.DictCountryDtoCreator;
import by.pilipuk.data.dtoCreators.RoomTypeDtoCreator;
import by.pilipuk.data.dtoCreators.HotelDtoCreator;
import by.pilipuk.data.dtoCreators.RoomDtoCreator;
import by.pilipuk.dto.AddressDto;
import by.pilipuk.dto.DictCityDto;
import by.pilipuk.dto.DictCountryDto;
import by.pilipuk.dto.RoomDto;
import by.pilipuk.dto.RoomTypeDto;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.entity.*;
import by.pilipuk.mappers.*;
import by.pilipuk.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CascadeRoomCreationTestService {

    @Autowired
    DictCountryDtoCreator dictCountryDtoCreator;
    @Autowired
    DictCityDtoCreator dictCityDtoCreator;
    @Autowired
    AddressDtoCreator addressDtoCreator;
    @Autowired
    RoomTypeDtoCreator roomTypeDtoCreator;

    @Autowired
    HotelDtoCreator hotelDtoCreator;

    @Autowired
    RoomDtoCreator roomDtoCreator;

    @Autowired
    DictCountryMapper dictCountryMapper;

    @Autowired
    DictCityMapper dictCityMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    RoomTypeMapper roomTypeMapper;

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    DictCountryRepository dictCountryRepository;

    @Autowired
    DictCityRepository dictCityRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomRepository roomRepository;

//    @Autowired
//    DtoCreators dtoCreators;

    public RoomDto createRoomDto() {

        DictCountryDto dictCountryDto = dictCountryDtoCreator.createDictCountryDto();
        DictCountry dictCountry = dictCountryRepository.save(dictCountryMapper.toEntity(dictCountryDto));

        DictCityDto dictCityDto = dictCityDtoCreator.createDictCityDto();
        DictCity dictCity = dictCityRepository.save(dictCityMapper.toEntity(dictCityDto));

        AddressDto addressDto = addressDtoCreator.createAddressDto(dictCountry, dictCity);
        Address address = addressRepository.save(addressMapper.toEntity(addressDto));

        RoomTypeDto roomTypeDto = roomTypeDtoCreator.createRoomTypeDto();
        RoomType roomType = roomTypeRepository.save(roomTypeMapper.toEntity(roomTypeDto));

        HotelDto hotelDto = hotelDtoCreator.createHotelDto(address);
        Hotel hotel = hotelRepository.save(hotelMapper.toEntity(hotelDto));

        RoomDto roomDto = roomDtoCreator.createRoomDto(roomType, hotel);
        Room room = roomRepository.save(roomMapper.toEntity(roomDto));

        return roomMapper.toDto(room);
    }
}