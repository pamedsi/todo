package com.clarotodo.repository;

import com.clarotodo.entity.*;

import java.util.*;

public interface TarefaRepository {
    void salvarTarefa(Tarefa tarefa);
    List<Tarefa> buscarTodasAsTarefas();
    Tarefa buscarTarefaPorIdentificador(UUID identificador);
}
