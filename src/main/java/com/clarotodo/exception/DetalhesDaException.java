package com.clarotodo.exception;

public record DetalhesDaException(
        String titulo,
        String mensagem,
        int status,
        String timestamp,
        String path,
        String metodo
) {}
