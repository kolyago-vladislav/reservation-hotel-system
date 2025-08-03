package by.pilipuk.dto;

import by.pilipuk.entity.Address;
import java.time.Instant;

public record HotelDto (
    Long id,
    String name,
    Short rating,
    Address address,
    boolean active,
    Instant created,
    Instant updated
) {}
