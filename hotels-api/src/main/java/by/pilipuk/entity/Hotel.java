package by.pilipuk.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.Instant;
import java.util.Set;

import lombok.Data;
import lombok.experimental.Accessors;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity(name = "hotels")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Short rating;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST)
    private Set<Room> rooms;

    @Column(name = "active")
    private boolean active;

    @CreatedDate
    @Column(name = "created")
    private Instant created;

    @LastModifiedDate
    @Column(name = "updated")
    private Instant updated;
}