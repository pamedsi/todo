package com.clarotodo.controller;

import com.clarotodo.dto.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/tarefa")
public interface TarefaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void postNovaTarefa(@RequestBody TarefaRequest tarefaRequest);

    @GetMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.OK)
    DetalhesDaTarefa detalharTarefa(@PathVariable UUID identificadorDaTarefa);

    @PatchMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void concluirTarefa(@PathVariable UUID identificadorDaTarefa);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<DetalhesDaTarefa> listarTodasAsTarefas();

    @DeleteMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaTodasTarefas(@PathVariable UUID identificadorDaTarefa);
}
