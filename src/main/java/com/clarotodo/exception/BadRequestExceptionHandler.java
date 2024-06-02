package com.clarotodo.exception;

import com.clarotodo.repository.*;
import jakarta.servlet.http.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.*;

import java.time.*;
import java.util.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestControllerAdvice
public class BadRequestExceptionHandler {
    private static final org.apache.logging.log4j.Logger log = getLogger(TarefaRepository.class);

    @ExceptionHandler ({HandlerMethodValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<DetalhesDaException> badRequestHandler(Exception exception, HttpServletRequest request) {
        log.info(exception.getClass());
        log.error(exception.getMessage());
        String errors;
        if (exception instanceof HandlerMethodValidationException) {errors = ((HandlerMethodValidationException) exception).getAllErrors().toString();}
        else if (exception instanceof MethodArgumentNotValidException) {errors = ((MethodArgumentNotValidException) exception).getAllErrors().toString();}
        else return null;
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DetalhesDaException(
                        "Bad Request",
                        getDefaultMessage(errors),
                        400,
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
        }

    @ExceptionHandler (HttpMessageNotReadableException.class)
    public ResponseEntity<DetalhesDaException> badRequestHandler(HttpMessageNotReadableException exception, HttpServletRequest request) {
        log.info(exception.getClass());
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DetalhesDaException(
                        "Bad Request",
                        "O tipo passado não está correto!",
                        400,
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
    }
    private String getDefaultMessage(String errorMessage) {
        return List.of(errorMessage.split("default message "))
                .getLast()
                .replaceAll("\\[", "")
                .replaceAll("]", "");
    }
}

