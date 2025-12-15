package by.pilipuk.repository;

import by.pilipuk.entity.Room;
import by.pilipuk.model.dto.RoomTypeCountProjection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Long> {

    //переделать через Specification
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
                       @Param("roomTypeIds") List<Long> roomTypeIds,
            @Param("hotelIds") List<Long> hotelIds,
            @Param("roomIds") List<Long> roomIds
                       @Param("roomTypeIds") List<Long> roomTypeIds,
            @Param("hotelIds") List<Long> hotelIds,
            @Param("roomIds") List<Long> roomIds
                       @Param("roomTypeIds") List<Long> roomTypeIds,
            @Param("hotelIds") List<Long> hotelIds,
            @Param("roomIds") List<Long> roomIds
    );

    @Query(value = """
        SELECT
        	r.hotel_id AS hotelId,
            rt.room_type AS roomType,
            COUNT(r.id) AS count
        FROM hotel.rooms r
        JOIN hotel.room_types rt ON rt.id = r.room_type_id
        GROUP BY r.hotel_id, rt.room_type
        ORDER BY r.hotel_id ASC, rt.room_type ASC
    """, nativeQuery = true)
    List<RoomTypeCountProjection> findRoomTypeCountsByHotel();

}
