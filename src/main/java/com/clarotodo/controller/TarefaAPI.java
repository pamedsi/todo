package com.clarotodo.controller;

import com.clarotodo.dto.*;
import jakarta.validation.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/tarefa")
public interface TarefaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    void postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);

    @PutMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void putEditarTarefa(@PathVariable UUID identificadorDaTarefa, @RequestBody @Valid TarefaRequest tarefaRequest);

    @PatchMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void concluirTarefa(@PathVariable UUID identificadorDaTarefa);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    Page<DetalhesDaTarefa> listarTarefas(
            @RequestParam(value = "query", required = false, defaultValue = "") String query,
            @RequestParam(value = "done", required = false, defaultValue = "") String done,
            @PageableDefault(size = 12, direction = Sort.Direction.ASC, sort = { "titulo" }) Pageable pageable
    );

    @DeleteMapping("/{identificadorDaTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletarTarefa(@PathVariable UUID identificadorDaTarefa);
}
