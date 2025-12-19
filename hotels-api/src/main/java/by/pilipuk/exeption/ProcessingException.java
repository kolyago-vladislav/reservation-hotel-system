package by.pilipuk.exeption;

import by.pilipuk.exeption.base.BaseProcessingException;
import by.pilipuk.model.dto.ExceptionContext;
import by.pilipuk.model.enums.ProcessingCode;
import org.apache.logging.log4j.spi.StandardLevel;
import static by.pilipuk.model.enums.ProcessingCode.FAILED_PROCESSING;

public class ProcessingException extends BaseProcessingException {

    private ProcessingException(
        StandardLevel level,
        ExceptionContext context,
        Throwable throwable
    ) {
        super(level, context, throwable);
    }

    public static ProcessingException create(Throwable throwable) {
        return new ProcessingException(
            FAILED_PROCESSING.getLevel(),
            ExceptionContext.create(FAILED_PROCESSING.name()),
            throwable
        );
    }

    public static ProcessingException create(
        ProcessingCode code,
        Throwable throwable
    ) {
        return new ProcessingException(
            code.getLevel(),
            ExceptionContext.create(code.name()),
            throwable
        );
    }

    public static ProcessingException create(
        ProcessingCode code,
        Object param,
        Throwable throwable
    ) {
        return new ProcessingException(
            code.getLevel(),
            ExceptionContext.create(code.name()).add(code.getKey(), param),
            throwable
        );
    }

}
