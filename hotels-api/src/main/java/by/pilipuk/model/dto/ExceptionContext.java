package by.pilipuk.model.dto;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Getter
@Setter
@FieldNameConstants
@NoArgsConstructor
public class ExceptionContext {

    private String code;
    private String message;
    private String field;
    private Object actual;
    private Object expected;
    private String object;
    private Map<String, Object> parameters;

    private ExceptionContext(String code) {
        this.code = code;
    }

    public static ExceptionContext create(String code) {
        return new ExceptionContext(code);
    }

    public ExceptionContext add(
        String key,
        Object value
    ) {
        if (parameters == null) {
            parameters = new HashMap<>();
        }

        parameters.put(key, value);
        return this;
    }
}
