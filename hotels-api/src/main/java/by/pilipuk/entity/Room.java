package by.pilipuk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "room_type_id")
    private Long roomTypeId;

    @Column(name = "hotel_id")
    private Long hotelId;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created")
    private Instant created;

    @Column(name = "updated")
    private Instant updated;
}