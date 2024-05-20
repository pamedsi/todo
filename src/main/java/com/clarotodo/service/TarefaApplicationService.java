package com.clarotodo.service;

import com.clarotodo.dto.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class TarefaApplicationService implements TarefaService {
    @Override
    public void criarNovaTarefa(TarefaRequest tarefaDTO) {

    }

    @Override
    public DetalhesDaTarefa detalharTarefa(UUID identificadorDaTarefa) {
        return null;
    }

    @Override
    public void concluirTarefa(UUID identificadorDaTarefa) {

    }

    @Override
    public List<DetalhesDaTarefa> listarTarefas() {
        return List.of();
    }

    @Override
    public void deletarTarefa(UUID identificadorDaTarefa) {

    }
}
