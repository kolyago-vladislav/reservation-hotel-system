package by.pilipuk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity(name = "dict_cities")
public class DictCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created")
    private Instant created;

    @Column(name = "updated")
    private Instant updated;
}
