package by.pilipuk.dto;

import by.pilipuk.entity.Address;
import lombok.Data;

import java.time.Instant;

@Data
public class HotelDto {

    private Long id;
    private String name;
    private Short rating;
    private Address address;
    private boolean active;
    private Instant created;
    private Instant updated;

}
