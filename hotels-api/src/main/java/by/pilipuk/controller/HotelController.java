package by.pilipuk.controller;

import by.pilipuk.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.HotelsApi;
import org.openapitools.model.HotelDto;
import org.openapitools.model.HotelWriteDto;
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