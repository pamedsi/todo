package com.clarotodo;

import com.clarotodo.dto.*;
import com.clarotodo.entity.*;

public class DataHelper {
    public static TarefaRequest criarTarefaDTO() {
        return new TarefaRequest("Tarefa de Teste", "Descrevendo o teste...");
    }

    public static Tarefa criarTarefa() {
        return new Tarefa(criarTarefaDTO());
    }
}
