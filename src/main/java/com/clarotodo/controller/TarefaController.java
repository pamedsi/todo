package com.clarotodo.controller;

import com.clarotodo.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TarefaController implements TarefaAPI {
    @Override
    public void postNovaTarefa(TarefaRequest tarefaRequest) {

    }

    @Override
    public DetalhesDaTarefa detalharTarefa(UUID identificadorDaTarefa) {
        return null;
    }

    @Override
    public void concluirTarefa(UUID identificadorDaTarefa) {

    }

    @Override
    public List<DetalhesDaTarefa> listarTodasAsTarefas() {
        return List.of();
    }

    @Override
    public void deletaTodasTarefas(UUID identificadorDaTarefa) {

    }
}
