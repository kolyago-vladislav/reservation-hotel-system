package by.pilipuk.repository;

import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
}
