package com.clarotodo.service;

import com.clarotodo.dto.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public interface TarefaService {
    void criarNovaTarefa(TarefaRequest tarefaDTO);
    DetalhesDaTarefa detalharTarefa(UUID identificadorDaTarefa);
    void concluirTarefa(UUID identificadorDaTarefa);
    List<DetalhesDaTarefa> listarTarefas();
    void deletarTarefa(UUID identificadorDaTarefa);
}
