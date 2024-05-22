package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.clarotodo.repository.TarefaRepository;
import com.clarotodo.service.TarefaService;
import com.fasterxml.jackson.databind.*;

import org.junit.jupiter.api.*;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import static com.clarotodo.DataHelper.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TarefaRepository tarefaRepository;
    @MockBean
    private TarefaService tarefaService;
    private final TarefaRequest tarefaDTO = criarTarefaDTO();
    private final Tarefa tarefa = criarTarefa();

    @Test
    void deveRetornar201AoCriarTarefa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tarefa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(tarefaDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated()
        );
        Mockito.verify(tarefaService, Mockito.times(1)).criarNovaTarefa(any());
    }

    @Test
    void deveConcluirTarefa() throws Exception {
        Mockito.when(tarefaRepository.buscarTarefaPorIdentificador(any())).thenReturn(tarefa);
        mockMvc.perform(MockMvcRequestBuilders.patch("/tarefa/" + tarefa.getIdentificador().toString()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        Mockito.verify(tarefaService, Mockito.times(1)).concluirTarefa(any());
    }

    @Test
    void deveListarTodasAsTarefas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tarefa")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(tarefaService, Mockito.times(1)).listarTarefas();
    }

    @Test
    void deveDeletarTarefa() throws Exception {
        Mockito.when(tarefaRepository.buscarTarefaPorIdentificador(any())).thenReturn(tarefa);
        mockMvc.perform(MockMvcRequestBuilders.delete("/tarefa/" + tarefa.getIdentificador().toString()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
        Mockito.verify(tarefaService, Mockito.times(1)).deletarTarefa(any());
    }
}