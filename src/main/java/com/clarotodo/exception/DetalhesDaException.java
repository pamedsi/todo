package com.clarotodo.exception;

import java.util.*;

public record DetalhesDaException(
        String titulo,
        String mensagem,
        int status,
        String timestamp,
        String path,
        String metodo
) {
    public static String getDefaultMessage(String errorMessage) {
        return List.of(errorMessage.split("default message "))
                .getLast()
                .replaceAll("\\[", "")
                .replaceAll("]", "");
    }
}
