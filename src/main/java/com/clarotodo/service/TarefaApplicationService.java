package com.clarotodo.service;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.clarotodo.repository.*;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.*;

import java.util.*;

import static org.apache.logging.log4j.LogManager.getLogger;

@Service
public class TarefaApplicationService implements TarefaService {
    private static final Logger log = getLogger(TarefaApplicationService.class);
    private final TarefaRepository tarefaRepository;

    public TarefaApplicationService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public void criarNovaTarefa(TarefaRequest tarefaDTO) {
        log.info("[Inicia]: TarefaApplicationService - criarNovaTarefa()");
        Tarefa tarefa = new Tarefa(tarefaDTO);
        tarefaRepository.salvarTarefa(tarefa);
        log.info("[Finaliza]: TarefaApplicationService - criarNovaTarefa()");
    }

    @Override
    public DetalhesDaTarefa buscarTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia]: TarefaApplicationService - detalharTarefa()");
        Tarefa tarefaDePersistencia = tarefaRepository.buscarTarefaPorIdentificador(identificadorDaTarefa);
        DetalhesDaTarefa tarefaDTO = new DetalhesDaTarefa(tarefaDePersistencia);
        log.info("[Finaliza]: TarefaApplicationService - detalharTarefa()");
        return tarefaDTO;
    }

    @Override
    public void concluirTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia]: TarefaApplicationService - concluirTarefa()");
        log.info("[Finaliza]: TarefaApplicationService - concluirTarefa()");
    }

    @Override
    public List<DetalhesDaTarefa> listarTarefas() {
        log.info("[Inicia]: TarefaApplicationService - listarTarefas()");
        List<Tarefa> tarefas = tarefaRepository.buscarTodasAsTarefas();
        List<DetalhesDaTarefa> tarefasDTO = DetalhesDaTarefa.converterVariosParaDTO(tarefas);
        log.info("[Finaliza]: TarefaApplicationService - listarTarefas()");
        return tarefasDTO;
    }

    @Override
    public void deletarTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia]: TarefaApplicationService - deletarTarefa()");
        log.info("[Finaliza]: TarefaApplicationService - deletarTarefa()");
    }
}

