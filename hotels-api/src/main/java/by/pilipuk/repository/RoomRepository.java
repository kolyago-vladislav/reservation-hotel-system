package by.pilipuk.repository;

import by.pilipuk.entity.Room;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long>, JpaSpecificationExecutor<Room> {

    @Query(value = """
        SELECT
        	r.hotel_id AS hotelId,
            rt.name AS roomType,
            COUNT(r.id) AS count
        FROM hotel.rooms r
        JOIN hotel.dict_room_types rt ON rt.id = r.dict_room_type_id
        GROUP BY r.hotel_id, rt.name
        ORDER BY r.hotel_id ASC, rt.name ASC
    """, nativeQuery = true)
    List<RoomTypeCountProjection> findRoomTypeCountsByHotel();

}