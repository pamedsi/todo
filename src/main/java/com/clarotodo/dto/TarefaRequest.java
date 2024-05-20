package com.clarotodo.dto;

import jakarta.validation.constraints.*;

public record TarefaRequest(
        @NotBlank (message = "Campo 'titulo' não pode estar vazio.")
        String titulo,
        @NotBlank (message = "Campo 'descricao' não pode estar vazio")
        String descricao
) {}
