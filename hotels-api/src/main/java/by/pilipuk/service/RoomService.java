package by.pilipuk.service;

import by.pilipuk.dto.dto.RoomDto;
import by.pilipuk.mapper.RoomMapper;
import by.pilipuk.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    public List<RoomDto> findAllFilteredRooms(List<Long> roomTypeIds, List<Long> hotelIds, List<Long> roomIds) {
        return roomRepository.findAllFilteredRooms(roomTypeIds, hotelIds, roomIds).stream()
                .map(roomMapper::from)
                .toList();
    }

    public Optional<RoomDto> getRoomById(Long id) {
        return roomRepository.findById(id)
                .map(roomMapper::from);
    }

}