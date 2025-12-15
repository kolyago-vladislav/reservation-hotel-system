package by.pilipuk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity(name = "dict_countries")
@Accessors(chain = true)
public class DictCountry extends BaseEntity<DictCountry> {

    @Column(name = "country")
    private String country;

}