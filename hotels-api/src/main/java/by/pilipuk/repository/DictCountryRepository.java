package by.pilipuk.repository;

import by.pilipuk.entity.DictCountry;
import by.pilipuk.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictCountryRepository extends JpaRepository<DictCountry, Long> {
}
