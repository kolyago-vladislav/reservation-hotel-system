package by.pilipuk.service;

import by.pilipuk.dto.RoomDto;
import by.pilipuk.dto.RoomPageDto;
import by.pilipuk.dto.RoomRequestDto;
import by.pilipuk.mapper.RoomMapper;
import by.pilipuk.mapper.RoomSpecificationMapper;
import by.pilipuk.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;
    private final RoomSpecificationMapper roomSpecificationMapper;

    public RoomPageDto getAllRooms(RoomRequestDto roomRequestDto, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        var spec = roomSpecificationMapper.roomSpecification(roomRequestDto);

        return roomMapper.toRoomPageDto(roomRepository.findAll(spec, pageable));
    }

    public RoomDto getRoomById(Long id) {
        var room = roomRepository.findByIdOrThrow(id);

        return roomMapper.from(room);
    }

}