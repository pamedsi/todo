package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.service.*;
import org.apache.logging.log4j.Logger;
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
    public List<DetalhesDaTarefa> listarTodasAsTarefas() {
        log.info("[Inicia]: TarefaController - listarTodasAsTarefas()");
        List<DetalhesDaTarefa> todasAsTarefas = tarefaService.listarTarefas();
        log.info("[Finaliza]: TarefaController - listarTodasAsTarefas()\n");
        return todasAsTarefas;
    }

    @Override
    public void deletaTodasTarefas(String identificadorDaTarefa) {
        log.info("[Inicia]: TarefaController - deletaTodasTarefas()");
        tarefaService.deletarTarefa(UUID.fromString(identificadorDaTarefa));
        log.info("[Finaliza]: TarefaController - deletaTodasTarefas()\n");
    }
}
