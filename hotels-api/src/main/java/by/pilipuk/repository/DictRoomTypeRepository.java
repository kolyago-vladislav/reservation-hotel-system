package by.pilipuk.repository;

import by.pilipuk.entity.DictRoomType;
import by.pilipuk.exeption.ValidationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DictRoomTypeRepository extends JpaRepository<DictRoomType, Long> {

    Optional<DictRoomType> findByName(String roomTypeName);

    default DictRoomType findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ValidationException("RoomType not found: " + id));
    }

}