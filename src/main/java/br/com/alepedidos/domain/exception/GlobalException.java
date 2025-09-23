package br.com.alepedidos.domain.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(MapperException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError mapperException(HttpServletRequest http,
            MapperException exception) {
        ApiError error = new ApiError("Erro ao converter classe",
                exception.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                http.getPathInfo(),
                LocalDateTime.now()
                        .toString(),
                List.of());
        log.error(error.toString());
        return error;
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError conflictException(HttpServletRequest http,
            ConflictException exception) {
        ApiError error = new ApiError("Conflito ao cadastrar",
                exception.getMessage(),
                HttpStatus.CONFLICT.value(),
                http.getPathInfo(),
                LocalDateTime.now()
                        .toString(),
                List.of());
        log.error(error.toString());
        return error;
    }

    @ExceptionHandler(DataAccessException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ApiError databaseUnavailable(HttpServletRequest http,
            Exception ex) {
        ApiError error = new ApiError("Banco de dados indisponível",
                ex.getMessage(),
                HttpStatus.SERVICE_UNAVAILABLE.value(),
                http.getRequestURI(),
                LocalDateTime.now()
                        .toString(),
                List.of());
        log.error(error.toString());
        return error;
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiError badCredentialsException(HttpServletRequest http,
            BadCredentialsException ex) {
        ApiError error = new ApiError("Usuário ou senha inválido.",
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                http.getRequestURI(),
                LocalDateTime.now()
                        .toString(),
                List.of());
        log.error(error.toString());
        return error;
    }

}
