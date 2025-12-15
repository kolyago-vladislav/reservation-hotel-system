package by.pilipuk.repository;

import by.pilipuk.entity.DictCity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCityRepository extends JpaRepository<DictCity, Long> {

    //toDO create ValidationException
    default DictCity findByIdOrThrow(Long id) {
        return findById(id)
            .orElseThrow(() -> new ValidationException("Country not found: " + city));
    }
}
