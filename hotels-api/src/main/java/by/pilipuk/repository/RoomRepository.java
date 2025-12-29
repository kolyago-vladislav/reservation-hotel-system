package by.pilipuk.repository;

import by.pilipuk.entity.Room;
import by.pilipuk.exeption.ValidationException;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import static by.pilipuk.model.enums.ValidationCode.NOT_FOUND_BY_ID;

public interface RoomRepository extends JpaRepository<Room, Long>, JpaSpecificationExecutor<Room> {

    default Room findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> ValidationException.create(NOT_FOUND_BY_ID, id));
    }

    @Query(value = """
        SELECT
        	r.hotel_id AS hotelId,
            rt.id AS roomTypeId,
            COUNT(r.id) AS count
        FROM hotel.rooms r
        JOIN hotel.dict_room_types rt ON rt.id = r.dict_room_type_id
        GROUP BY r.hotel_id, rt.id
        ORDER BY r.hotel_id ASC, rt.id ASC
    """, nativeQuery = true)
    List<RoomTypeCountProjection> findRoomTypeCountsByHotel();

}