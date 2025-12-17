package by.pilipuk.repository;

import by.pilipuk.entity.DictCountry;
import by.pilipuk.exeption.ValidationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCountryRepository extends JpaRepository<DictCountry, Long> {

    default DictCountry findByIdOrThrow(Long id) {
        return findById(id)
            .orElseThrow(() -> new ValidationException("Country not found: " + id));
    }
}
