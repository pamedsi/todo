package com.clarotodo.exception;

import com.clarotodo.repository.*;
import jakarta.servlet.http.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.time.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final org.apache.logging.log4j.Logger log = getLogger(TarefaRepository.class);

    @ExceptionHandler (APIException.class)
    public ResponseEntity<DetalhesDaException> APIExceptionHandler(APIException exception, HttpServletRequest request) {
        return ResponseEntity.status(exception.getHttpStatus()).body(
                new DetalhesDaException(
                        "Ocorreu um erro!",
                        exception.getMessage(),
                        exception.getHttpStatusInNumber(),
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
    }

    @ExceptionHandler (Exception.class)
    public ResponseEntity<DetalhesDaException> generalException(Exception exception, HttpServletRequest request) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new DetalhesDaException(
                        "Internal Server Error",
                        "Erro interno! Tente novamente mais tarde ou contate o suporte!",
                        500,
                        LocalDateTime.now().toString(),
                        request.getServletPath(),
                        request.getMethod()
                ));
    }
}
