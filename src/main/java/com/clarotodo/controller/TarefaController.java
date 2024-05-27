package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.service.*;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import static org.apache.logging.log4j.LogManager.getLogger;

@RestController
public class TarefaController implements TarefaAPI {
    private static final Logger log = getLogger(TarefaAPI.class);
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Override
    public void postNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[Inicia]: TarefaController - postNovaTarefa()");
        tarefaService.criarNovaTarefa(tarefaRequest);
        log.info("[Finaliza]: TarefaController - postNovaTarefa()\n");
    }

    @Override
    public void concluirTarefa(String identificadorDaTarefa) {
        log.info("[Inicia]: TarefaController - concluirTarefa()");
        tarefaService.concluirTarefa(UUID.fromString(identificadorDaTarefa));
        log.info("[Finaliza]: TarefaController - concluirTarefa()\n");
    }

    @Override
    public Page<DetalhesDaTarefa> listarTarefas(String termo, Pageable pageable) {
        log.info("[Inicia]: TarefaController - pesquisarTarefas()");
        Page<DetalhesDaTarefa> tarefasEncontradas = tarefaService.listarTarefas(termo, pageable);
        log.info("[Finaliza]: TarefaController - pesquisarTarefas()");
        return tarefasEncontradas;
    }

    @Override
    public void deletarTarefa(String identificadorDaTarefa) {
        log.info("[Inicia]: TarefaController - deletaTodasTarefas()");
        tarefaService.deletarTarefa(UUID.fromString(identificadorDaTarefa));
        log.info("[Finaliza]: TarefaController - deletaTodasTarefas()\n");
    }
}
