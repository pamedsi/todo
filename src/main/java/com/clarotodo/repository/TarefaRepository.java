package com.clarotodo.repository;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;

import java.util.*;

public interface TarefaRepository {
    void salvarTarefa(Tarefa tarefa);
    List<DetalhesDaTarefa> buscarTarefas();
}
