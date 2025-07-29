package by.pilipuk.dto;

import lombok.RequiredArgsConstructor;
import java.time.Instant;

@RequiredArgsConstructor
public class RoomTypeDto {

    private Long id;

    private String roomType;

    private boolean active;

    private Instant created;

    private Instant updated;
}
