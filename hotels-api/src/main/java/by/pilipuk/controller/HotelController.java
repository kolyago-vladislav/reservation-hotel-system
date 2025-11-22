package by.pilipuk.controller;

import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import by.pilipuk.api.HotelsApi;
import by.pilipuk.dto.HotelDto;
import by.pilipuk.dto.HotelWriteDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HotelController implements HotelsApi {

    private final HotelService hotelService;
    @Override
    public ResponseEntity<List<HotelDto>> getHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @Override
    public ResponseEntity<Void> addHotel(HotelWriteDto hotelWriteDto) {
        hotelService.addHotel(hotelWriteDto);
        return ResponseEntity.ok().build();
    }

}