package com.clarotodo.controller;

import com.clarotodo.dto.*;
import jakarta.validation.*;
import org.hibernate.validator.constraints.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tarefa")
public interface TarefaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);

    @PatchMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void concluirTarefa(@PathVariable @UUID(message = "Este UUID não é válido!") String identificadorDaTarefa);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<DetalhesDaTarefa> listarTodasAsTarefas();

    @DeleteMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletarTarefa(@PathVariable @UUID(message = "Este UUID não é válido!") String identificadorDaTarefa);
}
