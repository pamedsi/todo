package com.clarotodo.service;

import com.clarotodo.controller.*;
import com.clarotodo.dto.*;
import org.springframework.stereotype.*;

import java.util.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
public class TarefaApplicationService implements TarefaService {
    private static final org.apache.logging.log4j.Logger log = getLogger(TarefaApplicationService.class);

    @Override
    public void criarNovaTarefa(TarefaRequest tarefaDTO) {
        log.info("[Inicia] TarefaApplicationService - criarNovaTarefa()");
        // Lógica para criar a nova tarefa aqui
        log.info("[Finaliza] TarefaApplicationService - criarNovaTarefa()");
    }

    @Override
    public DetalhesDaTarefa detalharTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia] TarefaApplicationService - detalharTarefa()");
        DetalhesDaTarefa detalhes = null; // Simula a busca pela tarefa
        log.info("[Finaliza] TarefaApplicationService - detalharTarefa()");
        return detalhes;
    }

    @Override
    public void concluirTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia] TarefaApplicationService - concluirTarefa()");
        // Lógica para concluir a tarefa aqui
        log.info("[Finaliza] TarefaApplicationService - concluirTarefa()");
    }

    @Override
    public List<DetalhesDaTarefa> listarTarefas() {
        log.info("[Inicia] TarefaApplicationService - listarTarefas()");
        List<DetalhesDaTarefa> tarefas = List.of(); // Simula a lista de tarefas
        log.info("[Finaliza] TarefaApplicationService - listarTarefas()");
        return tarefas;
    }

    @Override
    public void deletarTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia] TarefaApplicationService - deletarTarefa()");
        // Lógica para deletar a tarefa aqui
        log.info("[Finaliza] TarefaApplicationService - deletarTarefa()");
    }
}

