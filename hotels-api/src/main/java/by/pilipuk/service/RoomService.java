package by.pilipuk.service;

import by.pilipuk.entity.Room;
import by.pilipuk.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public List<Room> getAllFilteredRooms(List<Long> roomTypeIds, List<Long> hotelIds, List<Long> roomIds) {
        return roomRepository.findAll().stream()
                .filter(room -> roomTypeIds == null || roomTypeIds.contains(room.getRoomType().getId()))
                .filter(room -> hotelIds == null || hotelIds.contains(room.getHotel().getId()))
                .filter(room -> roomIds == null || roomIds.contains(room.getId()))
                .toList();
    }

    public Optional<Room> getRoomById(Long id) {
        return this.roomRepository.findById(id);
    }

}