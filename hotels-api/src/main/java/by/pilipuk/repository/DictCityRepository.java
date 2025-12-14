package by.pilipuk.repository;

import by.pilipuk.entity.DictCity;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCityRepository extends JpaRepository<DictCity, Long> {

    Optional<DictCity> findByCity(String city);

    //toDO create ValidationException
    default DictCity findByCityOrThrow(String city) {
        return findByCity(city)
            .orElseThrow(() -> new IllegalArgumentException("Country not found: " + city));
    }
}
