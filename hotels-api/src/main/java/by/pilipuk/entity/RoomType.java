package by.pilipuk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.Instant;

@Data
@Entity(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "active")
    private boolean active;

    @Column(name = "created")
    private Instant created;

    @Column(name = "updated")
    private Instant updated;
}
