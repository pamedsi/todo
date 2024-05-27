package com.clarotodo.service;

import com.clarotodo.dto.*;
import org.springframework.data.domain.*;

import java.util.*;

public interface TarefaService {
    void criarNovaTarefa(TarefaRequest tarefaDTO);
    void concluirTarefa(UUID identificadorDaTarefa);
    Page<DetalhesDaTarefa> listarTarefas(String termo, String concluida, Pageable pageable);
    void deletarTarefa(UUID identificadorDaTarefa);
}
