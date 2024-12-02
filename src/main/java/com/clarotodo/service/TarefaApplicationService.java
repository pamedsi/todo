package com.clarotodo.service;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.clarotodo.repository.*;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.*;
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
    public void concluirTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia]: TarefaApplicationService - concluirTarefa()");
        Tarefa tarefa = tarefaRepository.buscarTarefaPorIdentificador(identificadorDaTarefa);
        tarefa.concluirTarefa();
        log.info("[Finaliza]: TarefaApplicationService - concluirTarefa()");
    }

    @Override
    public Page<DetalhesDaTarefa> listarTarefas(String termo, String concluida, Pageable pageable) {
        log.info("[Inicia]: TarefaApplicationService - listarTarefas()");
        Page<Tarefa> tarefas = tarefaRepository.listarTarefas(termo, concluida, pageable);
        Page<DetalhesDaTarefa> tarefasDTO = DetalhesDaTarefa.converterParaPageDTO(tarefas);
        log.info("[Finaliza]: TarefaApplicationService - listarTarefas()");
        return tarefasDTO;
    }

    @Override
    public void deletarTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia]: TarefaApplicationService - deletarTarefa()");
        Tarefa tarefa = tarefaRepository.buscarTarefaPorIdentificador(identificadorDaTarefa);
        tarefa.deletar();
        log.info("[Finaliza]: TarefaApplicationService - deletarTarefa()");
    }

    @Override
    public void editarTarefa(UUID identificadorDaTarefa, TarefaRequest tarefaRequest) {
        log.info("[Inicia]: TarefaApplicationService - editarTarefa()");
        Tarefa tarefa = tarefaRepository.buscarTarefaPorIdentificador(identificadorDaTarefa);
        tarefa.atualizarTarefa(tarefaRequest);
        log.info("[Finaliza]: TarefaApplicationService - editarTarefa()");
    }

    @Override
    public DetalhesDaTarefa buscarTarefa(UUID identificadorDaTarefa) {
        log.info("[Inicia]: TarefaApplicationService - buscarTarefa()");
        Tarefa tarefa = tarefaRepository.buscarTarefaPorIdentificador(identificadorDaTarefa);
        DetalhesDaTarefa tarefaDTO = new DetalhesDaTarefa(tarefa);
        log.info("[Finaliza]: TarefaApplicationService - buscarTarefa()");
        return tarefaDTO;
    }
}

