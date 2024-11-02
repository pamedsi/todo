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
    @Column (nullable = false, name = "created_at")
    private LocalDateTime criadaEm;
    @Column (nullable = false, name = "updated_at")
    private LocalDateTime ultimaAtualizacao;
    @Column (nullable = false, name = "deleted")
    private boolean deletada;

    public Tarefa(TarefaRequest tarefaDTO) {
        identificador = UUID.randomUUID();
        titulo = tarefaDTO.titulo();
        descricao = tarefaDTO.descricao();
        concluida = false;
        criadaEm = LocalDateTime.now();
        ultimaAtualizacao = LocalDateTime.now();
        deletada = false;
    }

    public void concluirTarefa() {
        concluida = true;
        ultimaAtualizacao = LocalDateTime.now();
    }

    public Tarefa() {}

    public UUID getIdentificador() { return this.identificador; }

    public String getTitulo() { return titulo; }

    public String getDescricao() { return descricao; }

    public void deletar() { deletada = true; }

    public boolean estaConcluida() { return this.concluida; }

    public boolean estaDeletada() { return this.deletada; }

    public void atualizarTarefa(TarefaRequest tarefaRequest) {
        titulo = tarefaRequest.titulo();
        descricao = tarefaRequest.descricao();
        ultimaAtualizacao = LocalDateTime.now();
    }
}
