package by.pilipuk.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity(name = "addresses")
@Accessors(chain = true)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @ManyToOne(/*cascade = CascadeType.PERSIST, */fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id", nullable = false)
    private DictCountry dictCountry;

    @ManyToOne(/*cascade = CascadeType.PERSIST, */fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", nullable = false)
    private DictCity dictCity;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created")
    @CreationTimestamp
    private Instant created;

    @Column(name = "updated")
    @UpdateTimestamp
    private Instant updated;

}