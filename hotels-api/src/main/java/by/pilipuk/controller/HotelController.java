package by.pilipuk.controller;

import by.pilipuk.dto.PageHotelDto;
import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import by.pilipuk.api.HotelsApi;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelsApi {

    private final HotelService hotelService;
    @Override
    public List<HotelDto> getHotels() {
        return hotelService.getAllHotels();
    }

    @Override
    public void addHotel(HotelWriteDto hotelWriteDto) {
        hotelService.addHotel(hotelWriteDto);
    }

    @Override
    public PageHotelDto getHotelsWithRoomCounts(Integer offset, Integer limit) {
        return hotelService.findHotelsWithRoomTypeCounts(offset, limit);
    }
}