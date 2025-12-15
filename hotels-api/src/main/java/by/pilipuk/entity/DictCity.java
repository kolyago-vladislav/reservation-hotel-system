package by.pilipuk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Entity(name = "dict_cities")
@Accessors(chain = true)
@EntityListeners(AuditingEntityListener.class)
public class DictCity extends BaseEntity<DictCity> {

    @Column(name = "city")
    private String city;

}
