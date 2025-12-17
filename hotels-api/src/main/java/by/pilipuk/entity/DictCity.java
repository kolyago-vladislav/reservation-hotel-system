package by.pilipuk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

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
public class DictCity extends BaseEntity {

    @Column(name = "name")
    private String name;

}
