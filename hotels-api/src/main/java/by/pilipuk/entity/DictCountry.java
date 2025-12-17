package by.pilipuk.entity;

import by.pilipuk.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "dict_countries", schema = "hotel")
@Accessors(chain = true)
public class DictCountry extends BaseEntity {

    @Column(name = "name")
    private String name;

}