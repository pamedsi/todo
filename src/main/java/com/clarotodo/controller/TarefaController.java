package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TarefaController implements TarefaAPI {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Override
    public void postNovaTarefa(TarefaRequest tarefaRequest) {
    }

    @Override
    public DetalhesDaTarefa detalharTarefa(UUID identificadorDaTarefa) {
        return null;
    }

    @Override
    public void concluirTarefa(UUID identificadorDaTarefa) {

    }

    @Override
    public List<DetalhesDaTarefa> listarTodasAsTarefas() {
        return List.of();
    }

    @Override
    public void deletaTodasTarefas(UUID identificadorDaTarefa) {

    }
}
