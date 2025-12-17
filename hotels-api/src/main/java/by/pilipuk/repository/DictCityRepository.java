package by.pilipuk.repository;

import by.pilipuk.entity.DictCity;
import by.pilipuk.exeption.ValidationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCityRepository extends JpaRepository<DictCity, Long> {

    default DictCity findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ValidationException("City not found: " + id));
    }
}
