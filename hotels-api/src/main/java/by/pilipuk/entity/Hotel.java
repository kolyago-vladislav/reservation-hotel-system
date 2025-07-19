package by.pilipuk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity(name = "hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private String rating;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created")
    private Instant created;

    @Column(name = "updated")
    private Instant updated;

}