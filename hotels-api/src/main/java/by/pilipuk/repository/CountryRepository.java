package by.pilipuk.repository;

import by.pilipuk.entity.Country;
import by.pilipuk.exeption.ValidationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import static by.pilipuk.model.enums.ValidationCode.NOT_FOUND_BY_ID;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    default Country findByIdOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> ValidationException.create(NOT_FOUND_BY_ID, id));
    }
}
