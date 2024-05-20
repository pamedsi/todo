package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.service.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestController
public class TarefaController implements TarefaAPI {
    private static final org.apache.logging.log4j.Logger log = getLogger(TarefaAPI.class);
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Override
    public void postNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[Inicia]: TarefaController - postNovaTarefa()");
        log.info("[Finaliza]: TarefaController - postNovaTarefa()");
    }

    @Override
    public DetalhesDaTarefa detalharTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia] TarefaController - detalharTarefa()");
        log.info("[Finaliza] TarefaController - detalharTarefa()");
        return null;
    }

    @Override
    public void concluirTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia] TarefaController - concluirTarefa()");
        log.info("[Finaliza] TarefaController - concluirTarefa()");
    }

    @Override
    public List<DetalhesDaTarefa> listarTodasAsTarefas() {
        log.info("[Inicia] TarefaController - listarTodasAsTarefas()");
        List<DetalhesDaTarefa> todasAsTarefas = List.of();
        log.info("[Finaliza] TarefaController - listarTodasAsTarefas()");
        return todasAsTarefas;
    }

    @Override
    public void deletaTodasTarefas(UUID identificadorDaTarefa) {
        log.info("[Inicia] TarefaController - deletaTodasTarefas()");
        log.info("[Finaliza] TarefaController - deletaTodasTarefas()");
    }
}
