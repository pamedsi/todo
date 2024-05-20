package com.clarotodo.service;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.clarotodo.repository.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import java.util.*;

import static com.clarotodo.DataHelper.criarTarefa;
import static com.clarotodo.DataHelper.criarTarefaDTO;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TarefaApplicationServiceTest {
    @InjectMocks
    private TarefaApplicationService tarefaService;
    @Mock
    private TarefaRepository tarefaRepository;
    private final TarefaRequest tarefaDTO = criarTarefaDTO();
    private final Tarefa tarefa = criarTarefa();

    @Test
    void deveCriarNovaTarefa() {
        // Dado
        tarefaService.criarNovaTarefa(tarefaDTO);
        // Verifique
        Mockito.verify(tarefaRepository, Mockito.times(1)).salvarTarefa(any());
    }

    @Test
    void buscarTarefa() {
        // Quando
        Mockito.when(tarefaRepository.buscarTarefaPorIdentificador(any())).thenReturn(tarefa);
        // Dado
        tarefaService.buscarTarefa(tarefa.getIdentificador());
        // Verifique
        Mockito.verify(tarefaRepository, Mockito.times(1)).buscarTarefaPorIdentificador(any());
    }

    @Test
    void concluirTarefa() {
        // Quando
        Mockito.when(tarefaRepository.buscarTarefaPorIdentificador(any())).thenReturn(tarefa);
        // Dado
        tarefaService.concluirTarefa(tarefa.getIdentificador());
        // Verifique
        assertTrue(tarefa.estaConcluida());
        Mockito.verify(tarefaRepository, Mockito.times(1)).salvarTarefa(any());
    }

    @Test
    void listarTarefas() {
        // Quando
        Mockito.when(tarefaRepository.buscarTodasAsTarefas()).thenReturn(List.of(tarefa));
        // Quando
        tarefaService.listarTarefas();
        // Verifique
        Mockito.verify(tarefaRepository, Mockito.times(1)).buscarTodasAsTarefas();
    }

    @Test
    void deletarTarefa() {
        // Quando
        Mockito.when(tarefaRepository.buscarTarefaPorIdentificador(any())).thenReturn(tarefa);
        // Dado
        tarefaService.deletarTarefa(tarefa.getIdentificador());
        // Verifique
        assertTrue(tarefa.estaDeletada());
        Mockito.verify(tarefaRepository, Mockito.times(1)).salvarTarefa(any());
    }
}