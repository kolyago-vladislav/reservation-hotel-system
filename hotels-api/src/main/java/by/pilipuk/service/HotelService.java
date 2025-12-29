package by.pilipuk.service;

import by.pilipuk.dto.*;
import by.pilipuk.mapper.HotelMapper;
import by.pilipuk.mapper.HotelSpecificationMapper;
import by.pilipuk.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelMapper hotelMapper;
    private final HotelSpecificationMapper hotelSpecificationMapper;

    private final HotelRepository hotelRepository;

    public HotelPageDto getAllHotels(HotelRequestDto hotelRequestDto, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        var spec = hotelSpecificationMapper.hotelSpecification(hotelRequestDto);
        return hotelMapper.toHotelPageDto(hotelRepository.findAll(spec, pageable));
    }

    public HotelDto getHotelById(Long hotelId) {
        var hotel = hotelRepository.findByIdOrThrow(hotelId);
        return hotelMapper.from(hotel);
    }

    @Transactional
    public void createHotel(HotelWriteDto hotelWriteDto) {
        var hotel = hotelMapper.to(hotelWriteDto);
        hotelRepository.save(hotel);
    }

}