package by.pilipuk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;

import lombok.Data;
import lombok.experimental.Accessors;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity(name = "room_types")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "active")
    private boolean active;

    @CreatedDate
    @Column(name = "created")
    private Instant created;

    @LastModifiedDate
    @Column(name = "updated")
    private Instant updated;
}
