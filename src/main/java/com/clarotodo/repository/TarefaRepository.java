package com.clarotodo.repository;

import com.clarotodo.entity.*;
import org.springframework.data.domain.*;

import java.util.*;

public interface TarefaRepository {
    void salvarTarefa(Tarefa tarefa);
    Page<Tarefa> buscarTodasAsTarefas(Pageable pageable);
    Page<Tarefa> listarTarefas(String termo, Pageable pageable);
    Tarefa buscarTarefaPorIdentificador(UUID identificador);
}
