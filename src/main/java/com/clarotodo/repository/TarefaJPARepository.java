package com.clarotodo.repository;

import com.clarotodo.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface TarefaJPARepository extends JpaRepository <Tarefa, Long>{
}
