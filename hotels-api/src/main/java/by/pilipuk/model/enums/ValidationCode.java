package by.pilipuk.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import org.slf4j.event.Level;

import static org.slf4j.event.Level.DEBUG;

@Getter
@RequiredArgsConstructor
public enum ValidationCode {
    NOT_FOUND_BY_ID(DEBUG, "id");

    private final Level level;
    private String key;

    ValidationCode(
        Level level,
        String key
    ) {
        this.level = level;
        this.key = key;
    }
}
