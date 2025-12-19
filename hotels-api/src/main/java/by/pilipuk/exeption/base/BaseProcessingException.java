package by.pilipuk.exeption.base;

import by.pilipuk.model.dto.ExceptionContext;
import org.apache.logging.log4j.spi.StandardLevel;

/**
 * This exception serves as a wrapper used to rethrow exceptions in
 * scenarios where the method signature does not allow declaring them, while
 * still preserving the original cause for diagnostic purposes.
 */
public class BaseProcessingException extends BaseApplicationException {

    public static final String CODE = "APPLICATION_PROCESSING_EXCEPTION";

    public BaseProcessingException(
        StandardLevel level,
        ExceptionContext context,
        Throwable throwable
    ) {
        super(CODE, level, context, throwable);
    }

}
