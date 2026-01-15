package by.pilipuk.mapper;

import by.pilipuk.exeption.base.BaseApplicationException;
import by.pilipuk.model.dto.ExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
@Setter(onMethod_ = @Autowired)
public abstract class ExceptionMapper {

    @Mapping(target = "status", source = "status")
    @Mapping(target = "code", source = "ex.context.code")
    @Mapping(target = "message", source = "ex.message")
    @Mapping(target = "url", source = "request.requestURI")
    @Mapping(target = "timestamp", expression = "java(java.time.Instant.now())")
    public abstract ExceptionDto toDto(BaseApplicationException ex, HttpServletRequest request, int status);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "code", source = "code")
    @Mapping(target = "message", source = "ex.message")
    @Mapping(target = "url", source = "request.requestURI")
    @Mapping(target = "timestamp", expression = "java(java.time.Instant.now())")
    public abstract ExceptionDto toDto(Exception ex, HttpServletRequest request, int status, String code);
}
