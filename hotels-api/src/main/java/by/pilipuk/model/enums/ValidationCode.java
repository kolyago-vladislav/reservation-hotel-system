package by.pilipuk.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.spi.StandardLevel;

import static org.apache.logging.log4j.spi.StandardLevel.DEBUG;


@Getter
@RequiredArgsConstructor
public enum ValidationCode {
    NOT_FOUND_BY_ID(DEBUG, "id");

    private final StandardLevel level;
    private String key;

    ValidationCode(
        StandardLevel level,
        String key
    ) {
        this.level = level;
        this.key = key;
    }
}
