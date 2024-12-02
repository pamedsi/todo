package com.clarotodo.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.*;

public record TarefaRequest(
        @NotBlank (message = "Campo 'titulo' não pode estar vazio.")
        @Length(max = 255, message = "Titulo não pode ser maior que 255 caracteres.")
        String titulo,
        @NotBlank (message = "Campo 'descricao' não pode estar vazio")
        String descricao,
        boolean concluida
) {}
