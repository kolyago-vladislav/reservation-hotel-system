package by.pilipuk.dto;

import by.pilipuk.entity.Hotel;
import by.pilipuk.entity.RoomType;

import java.time.Instant;

public record RoomDto (
    Long id,
    String description,
    RoomType roomType,
    Hotel hotel,
    boolean active,
    Instant created,
    Instant updated
) {}