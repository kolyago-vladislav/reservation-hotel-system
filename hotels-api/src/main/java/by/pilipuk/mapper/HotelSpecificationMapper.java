package by.pilipuk.mapper;

import by.pilipuk.dto.HotelRequestDto;
import by.pilipuk.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class HotelSpecificationMapper {

    private HotelSpecificationMapper() {}

    public Specification<Hotel> hotelSpecification(HotelRequestDto hotelRequestDto) {
        return Specification.allOf(
                hasNames(hotelRequestDto.getNames()),
                hasCityIds(hotelRequestDto.getCityIds()),
                ratingGreaterThan(hotelRequestDto.getRatingFrom()),
                ratingLessThan(hotelRequestDto.getRatingTo()));
    }

    private static Specification<Hotel> hasNames(List<String> names) {
        return (root, query, cb) -> {
            if (names == null || names.isEmpty()) {
                return cb.conjunction();
            }
            if (names.size() == 1) {
                String pattern = "%" + names.get(0) + "%";
                return cb.like(root.get("name"), pattern);
            } else {
                return root.get("name").in(names);
            }
        };
    }

    private static Specification<Hotel> hasCityIds(List<Long> cityIds) {
        return (root, query, cb) ->
                (cityIds == null || cityIds.isEmpty())
                        ? cb.conjunction()
                        : root.get("address").get("city").get("id").in(cityIds);
    }

    private static Specification<Hotel> ratingGreaterThan(Integer ratingFrom) {
        return (root, query, cb) ->
                (ratingFrom == null || ratingFrom == 0)
                        ? cb.conjunction()
                        : cb.greaterThanOrEqualTo(root.get("rating"), ratingFrom);
    }

    private static Specification<Hotel> ratingLessThan(Integer ratingTo) {
        return (root, query, cb) ->
                (ratingTo == null || ratingTo == 0)
                        ? cb.conjunction()
                        : cb.lessThanOrEqualTo(root.get("rating"), ratingTo);
    }

}