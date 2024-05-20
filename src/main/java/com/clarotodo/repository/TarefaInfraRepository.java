package com.clarotodo.repository;

import com.clarotodo.entity.*;
import com.clarotodo.exception.*;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.util.*;
import static org.apache.logging.log4j.LogManager.getLogger;

@Repository
public class TarefaInfraRepository implements TarefaRepository{
    private static final Logger log = getLogger(TarefaRepository.class);
    private final TarefaJPARepository tarefaJPARepository;

    public TarefaInfraRepository(TarefaJPARepository tarefaJPARepository) {
        this.tarefaJPARepository = tarefaJPARepository;
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        log.info("[Inicia]: TarefaInfraRepository - salvarTarefa()");
        tarefaJPARepository.save(tarefa);
        log.info("[Finaliza]: TarefaInfraRepository - salvarTarefa()");
    }

    @Override
    public List<Tarefa> buscarTodasAsTarefas() {
        log.info("[Inicia]: TarefaInfraRepository - buscarTodasAsTarefas()");
        List<Tarefa> tarefas = tarefaJPARepository.findAllByDeletadaFalse();
        log.info("[Finaliza]: TarefaInfraRepository - buscarTodasAsTarefas()");
        return tarefas;
    }

    @Override
    public Tarefa buscarTarefaPorIdentificador(UUID identificador) {
        log.info("[Inicia]: TarefaInfraRepository - buscarTarefaPorIdentificador()");
        Tarefa tarefa = tarefaJPARepository.findByIdentificadorAndDeletadaFalseOrderByCriadaEmAsc(identificador).orElseThrow(
                () -> {
                       log.error("Tarefa não encontrada! Aplicação encerrada.");
                       return new APIException("Tarefa não encontrada!", HttpStatus.NOT_FOUND);
                }
        );
        log.info("[Finaliza]: TarefaInfraRepository - buscarTarefaPorIdentificador()");
        return tarefa;
    }
}
