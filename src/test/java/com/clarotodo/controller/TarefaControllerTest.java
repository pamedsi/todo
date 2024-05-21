package com.clarotodo.controller;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;
import com.fasterxml.jackson.databind.*;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.context.*;
import org.springframework.http.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.*;

import static com.clarotodo.DataHelper.*;

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerTest {
    @Autowired
    private MockMvc mockMvc;
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