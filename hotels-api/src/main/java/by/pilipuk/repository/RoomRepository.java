package by.pilipuk.repository;

import by.pilipuk.dto.RoomTypeCountDto;
import by.pilipuk.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = """
        SELECT * FROM hotel.rooms
        WHERE (:roomTypeIds IS NULL OR room_type_id IN (:roomTypeIds))
            AND (:hotelIds IS NULL OR hotel_id IN (:hotelIds))
            AND (:roomIds IS NULL OR id IN (:roomIds))
    """, nativeQuery = true)
    List<Room> findAllFilteredRooms(
            @Param("roomTypeIds") List<Long> roomTypeIds,
            @Param("hotelIds") List<Long> hotelIds,
            @Param("roomIds") List<Long> roomIds
    );

    @Query(value = """
        SELECT
            r.hotel_id AS hotelId,
            r.room_type_id AS roomTypeId,
            COUNT(r.id) AS count
        FROM rooms r
        GROUP BY r.hotel_id, r.room_type_id
        ORDER BY r.hotel_id, r.room_type_id
    """, nativeQuery = true)
    List<RoomTypeCountDto> findRoomTypeCountsByHotel();

}