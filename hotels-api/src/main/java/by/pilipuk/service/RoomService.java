package by.pilipuk.service;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;
import by.pilipuk.mappers.RoomMapper;
import by.pilipuk.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    public List<RoomDto> findAllFilteredRooms(List<Long> roomTypeIds, List<Long> hotelIds, List<Long> roomIds) {
        return this.roomRepository.findAllFilteredRooms(roomTypeIds, hotelIds, roomIds).stream()
                .map(roomMapper::toDto)
                .toList();
    }

    public Optional<RoomDto> getRoomById(Long id) {
        return this.roomRepository.findById(id)
                .map(roomMapper::toDto);
    }

}