package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.clarotodo.service.*;
import com.fasterxml.jackson.databind.*;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import static com.clarotodo.DataHelper.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerTest {
    @Autowired
    private MockMvc mockMvc;
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
    }

    @Test
    void deveDetalharTarefa() throws Exception {
        when(tarefaService.buscarTarefa(any())).thenReturn(criarDetalhesDaTarefa());
        mockMvc.perform(MockMvcRequestBuilders.get("/tarefa/" + tarefa.getIdentificador().toString())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.titulo").value(tarefa.getTitulo()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.descricao").value(tarefa.getDescricao()));
        ;
    }

    @Test
    void deveConcluirTarefa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/tarefa/" + tarefa.getIdentificador().toString()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    void deveListarTodasAsTarefas() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tarefa")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deveDeletarTarefa() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/tarefa/" + tarefa.getIdentificador().toString()))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}