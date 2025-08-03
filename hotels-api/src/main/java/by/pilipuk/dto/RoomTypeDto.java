package by.pilipuk.dto;

import java.time.Instant;

public record RoomTypeDto (
    Long id,
    String roomType,
    boolean active,
    Instant created,
    Instant updated
) {}