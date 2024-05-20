package com.clarotodo;

import com.clarotodo.dto.*;

public class DataHelper {
    public static TarefaRequest criarTarefaDTO() {
        return new TarefaRequest("Tarefa de Teste", "Descrevendo o teste...");
    }
}
