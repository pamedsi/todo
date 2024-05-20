package com.clarotodo.repository;

import com.clarotodo.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface TarefaJPARepository extends JpaRepository <Tarefa, Long>{
    Optional<Tarefa> findByIdentificadorAndDeletadaFalseOrderByCriadaEmAsc(UUID identificador);
    List<Tarefa> findAllByDeletadaFalse();
}
