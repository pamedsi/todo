package com.clarotodo.service;

import com.clarotodo.dto.*;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

public interface TarefaService {
    void criarNovaTarefa(TarefaRequest tarefaDTO);
    @Transactional
    void concluirTarefa(UUID identificadorDaTarefa);
    Page<DetalhesDaTarefa> listarTarefas(String termo, String concluida, Pageable pageable);
    @Transactional
    void deletarTarefa(UUID identificadorDaTarefa);
    @Transactional
    void editarTarefa(UUID identificadorDaTarefa, TarefaRequest tarefaRequest);
    DetalhesDaTarefa buscarTarefa(UUID identificadorDaTarefa);
}
