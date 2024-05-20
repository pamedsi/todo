package com.clarotodo.repository;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.clarotodo.service.*;
import org.springframework.stereotype.*;

import java.util.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@Repository
public class TarefaInfraRepository implements TarefaRepository{
    private static final org.apache.logging.log4j.Logger log = getLogger(TarefaRepository.class);
    private final TarefaService tarefaService;

    public TarefaInfraRepository(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        log.info("[Inicia] - salvarTarefa()");
        log.info("[Finaliza] - salvarTarefa()");
    }

    @Override
    public List<DetalhesDaTarefa> buscarTarefas() {
        log.info("[Inicia] - buscarTarefas()");
        log.info("[Finaliza] - buscarTarefas()");
        return List.of();
    }
}
