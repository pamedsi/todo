package com.clarotodo.entity;

import com.clarotodo.dto.*;
import jakarta.persistence.*;

import java.time.*;
import java.util.*;

@Entity
@Table (name = "tasks")
public class Tarefa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false, name = "identifier")
    private UUID identificador;
    @Column (nullable = false, name = "title")
    private String titulo;
    @Column (nullable = false, name = "description", columnDefinition = "text")
    private String descricao;
    @Column (nullable = false, name = "completed")
    private boolean concluida;
    @Column (nullable = false, name = "createdAt")
    private LocalDateTime criadaEm;
    @Column (nullable = false, name = "updatedAt")
    private LocalDateTime ultimaAtualizacao;

    public Tarefa(TarefaRequest tarefaDTO) {
        identificador = UUID.randomUUID();
        titulo = tarefaDTO.titulo();
        descricao = tarefaDTO.descricao();
        concluida = false;
        criadaEm = LocalDateTime.now();
        ultimaAtualizacao = LocalDateTime.now();
    }

    public void concluirTarefa() {
        this.concluida = true;
        ultimaAtualizacao = LocalDateTime.now();
    }

    public Tarefa() {}

    public UUID getIdentificador() {return this.identificador;}

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}
