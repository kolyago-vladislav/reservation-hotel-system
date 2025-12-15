package by.pilipuk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "room_types", schema = "hotel")
@Accessors(chain = true)
public class RoomType extends BaseEntity {

    @Column(name = "room_type")
    private String roomType;

}
