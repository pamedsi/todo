package com.clarotodo.service;

import com.clarotodo.dto.*;

import java.util.*;

public interface TarefaService {
    void criarNovaTarefa(TarefaRequest tarefaDTO);
    void concluirTarefa(UUID identificadorDaTarefa);
    List<DetalhesDaTarefa> listarTarefas();
    void deletarTarefa(UUID identificadorDaTarefa);
}
