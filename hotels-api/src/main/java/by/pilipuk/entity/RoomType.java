package by.pilipuk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity(name = "room_types")
@Accessors(chain = true)
public class RoomType extends BaseEntity<RoomType> {

    @Column(name = "room_type")
    private String roomType;

}
