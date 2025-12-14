package by.pilipuk.repository;

import by.pilipuk.entity.DictCountry;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCountryRepository extends JpaRepository<DictCountry, Long> {

    Optional<DictCountry> findByCountry(String country);
//
    //toDO create ValidationException
    default DictCountry findByCountryOrThrow(String country) {
        return findByCountry(country)
            .orElseThrow(() -> new IllegalArgumentException("Country not found: " + country));
    }
}
