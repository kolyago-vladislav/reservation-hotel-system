package by.pilipuk.dto;

import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.RoomType;
import lombok.Data;
import java.time.Instant;

@Data
public class RoomDto {

    private Long id;
    private String description;
    private RoomType roomType;
    private Hotel hotel;
    private boolean active;
    private Instant created;
    private Instant updated;

}