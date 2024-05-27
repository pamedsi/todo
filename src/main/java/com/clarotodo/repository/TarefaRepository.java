package com.clarotodo.repository;

import com.clarotodo.entity.*;
import org.springframework.data.domain.*;

import java.util.*;

public interface TarefaRepository {
    void salvarTarefa(Tarefa tarefa);
    Page<Tarefa> buscarTodasAsTarefas(Pageable pageable);
    Tarefa buscarTarefaPorIdentificador(UUID identificador);
}
