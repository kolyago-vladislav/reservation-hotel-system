package by.pilipuk.entity;

import by.pilipuk.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity
@Table(name = "dict_cities", schema = "hotel")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class City extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "dict_countries_to_dict_cities",
            schema = "hotel",
            joinColumns = @JoinColumn(name = "dict_city_id"),
            inverseJoinColumns = @JoinColumn(name = "dict_country_id")
    )
    private Country country;

}
