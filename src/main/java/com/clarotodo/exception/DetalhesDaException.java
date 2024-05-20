package com.clarotodo.exception;

import java.util.*;

public record DetalhesDaException(
        String titulo,
        String mensagem,
        int status,
        String timestamp,
        String path,
        String metodo
) {}
