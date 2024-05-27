package com.clarotodo.dto;

import com.clarotodo.entity.*;
import org.springframework.data.domain.*;

import java.util.*;

public record DetalhesDaTarefa(
        UUID identificador,
        String titulo,
        String descricao,
        boolean concluida
) {
    public DetalhesDaTarefa(Tarefa tarefa) {
        this(tarefa.getIdentificador(), tarefa.getTitulo(), tarefa.getDescricao(), tarefa.estaConcluida());
    }

    public static List<DetalhesDaTarefa> converterVariosParaDTO(List<Tarefa> tarefa) {
        return tarefa.stream().map(DetalhesDaTarefa::new).toList();
    }

    public static Page<DetalhesDaTarefa> converterParaPageDTO(Page<Tarefa> page) {
        List<DetalhesDaTarefa> listaDeDTO = converterVariosParaDTO(page.getContent());
        return new PageImpl<>(listaDeDTO, page.getPageable(), page.getTotalElements());
    }
}
