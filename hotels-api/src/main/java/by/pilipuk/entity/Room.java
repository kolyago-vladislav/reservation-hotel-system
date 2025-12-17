package by.pilipuk.entity;

import by.pilipuk.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "rooms", schema = "hotel")
@Accessors(chain = true)
public class Room extends BaseEntity {

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "dict_room_type_id", nullable = false)
    private DictRoomType dictRoomType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

}