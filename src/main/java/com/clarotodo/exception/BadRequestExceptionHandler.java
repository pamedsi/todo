package com.clarotodo.exception;

import com.clarotodo.repository.*;
import jakarta.servlet.http.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.*;

import java.time.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestControllerAdvice
public class BadRequestExceptionHandler {
    private static final org.apache.logging.log4j.Logger log = getLogger(TarefaRepository.class);

    @ExceptionHandler (HandlerMethodValidationException.class)
    public ResponseEntity<DetalhesDaException> badRequestHandler(HandlerMethodValidationException exception, HttpServletRequest request) {
        log.info(exception.getClass());
        log.error(exception.getMessage());
        String errors = exception.getAllErrors().toString();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DetalhesDaException(
                        "Bad Request",
                        DetalhesDaException.getDefaultMessage(errors),
                        400,
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
        }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<DetalhesDaException> badRequestHandler(MethodArgumentNotValidException exception, HttpServletRequest request) {
        log.info(exception.getClass());
        log.error(exception.getMessage());
        String errors = exception.getAllErrors().toString();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new DetalhesDaException(
                        "Bad Request",
                        DetalhesDaException.getDefaultMessage(errors),
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
}

