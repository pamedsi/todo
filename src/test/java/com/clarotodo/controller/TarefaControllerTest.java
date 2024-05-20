package com.clarotodo.controller;

import com.clarotodo.dto.*;
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

@SpringBootTest
@AutoConfigureMockMvc
class TarefaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TarefaService tarefaService;

    @Test
    void postNovaTarefaTeste() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tarefa")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsBytes(criarTarefaDTO()))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated()
                );
    }

    @Test
    void detalharTarefaTeste() {
    }

    @Test
    void concluirTarefaTeste() {
    }

    @Test
    void listarTodasAsTarefasTeste() {
    }

    @Test
    void deletaTodasTarefasTest() {
    }
}