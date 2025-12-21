package by.pilipuk.entity;

import by.pilipuk.entity.base.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@Entity
@Table(name = "hotels", schema = "hotel")
@Accessors(chain = true)
@FieldNameConstants
public class Hotel extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private Short rating;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Room> rooms;

}