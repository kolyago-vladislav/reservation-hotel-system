package by.pilipuk.service;

import by.pilipuk.dto.DictRoomTypeDto;
import by.pilipuk.dto.RoomDto;
import by.pilipuk.entity.Room;
import by.pilipuk.mapper.RoomMapper;
import by.pilipuk.mapper.RoomTypeMapper;
import by.pilipuk.repository.DictRoomTypeRepository;
import by.pilipuk.repository.RoomRepository;
import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    private final DictRoomTypeRepository dictRoomTypeRepository;

    private final RoomTypeMapper roomTypeMapper;

    public List<RoomDto> findAllFilteredRooms(List<Long> roomTypeIds, List<Long> hotelIds, List<Long> roomIds) {

        Specification<Room> spec = FilterSpecificationForRoom(roomTypeIds, hotelIds, roomIds);

        return roomRepository.findAll(spec).stream()
                .map(roomMapper::from)
                .toList();
    }

    public static Specification<Room> FilterSpecificationForRoom(List<Long> dictRoomTypeIds, List<Long> hotelIds, List<Long> roomIds) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dictRoomTypeIds != null && !dictRoomTypeIds.isEmpty()) {
                predicates.add(root.get("dictRoomType").get("id").in(dictRoomTypeIds));
            }

            if (hotelIds != null && !hotelIds.isEmpty()) {
                predicates.add(root.get("hotel").get("id").in(hotelIds));
            }

            if (roomIds != null && !roomIds.isEmpty()) {
                predicates.add(root.get("id").in(roomIds));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    public RoomDto getRoomById(Long id) {
        var room = roomRepository.findByIdOrThrow(id);

        return roomMapper.from(room);
    }

    public List<DictRoomTypeDto> getAllDictRoomTypes() {
        return dictRoomTypeRepository.findAll().stream().map(roomTypeMapper::from).toList();
    }
}