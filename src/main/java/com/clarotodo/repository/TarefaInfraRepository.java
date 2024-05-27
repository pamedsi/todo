package com.clarotodo.repository;

import com.clarotodo.entity.*;
import com.clarotodo.exception.*;
import jakarta.annotation.*;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;

import java.util.*;
import static org.apache.logging.log4j.LogManager.getLogger;

@Repository
public class TarefaInfraRepository implements TarefaRepository {
    private static final Logger log = getLogger(TarefaRepository.class);
    private final TarefaJPARepository tarefaJPARepository;
    private final EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    @PostConstruct
    private void instanciarCriteriaBuilder() { this.criteriaBuilder = entityManager.getCriteriaBuilder(); }

    public TarefaInfraRepository(TarefaJPARepository tarefaJPARepository, EntityManager entityManager) {
        this.tarefaJPARepository = tarefaJPARepository;
        this.entityManager = entityManager;
    }

    @Override
    public void salvarTarefa(Tarefa tarefa) {
        log.info("[Inicia]: TarefaInfraRepository - salvarTarefa()");
        tarefaJPARepository.save(tarefa);
        log.info("[Finaliza]: TarefaInfraRepository - salvarTarefa()");
    }

    @Override
    public Page<Tarefa> buscarTodasAsTarefas(Pageable pageable) {
        log.info("[Inicia]: TarefaInfraRepository - buscarTodasAsTarefas()");
        Page<Tarefa> tarefas = tarefaJPARepository.findAllByDeletadaFalse(pageable);
        log.info("[Finaliza]: TarefaInfraRepository - buscarTodasAsTarefas()");
        return tarefas;
    }

    @Override
    public Page<Tarefa> listarTarefas(String  termo, String concluida, Pageable pageable) {
        log.info("[Inicia] TarefaInfraRepository - pesquisarTarefa()");
        CriteriaQuery<Tarefa> criteriaQuery = criteriaBuilder.createQuery(Tarefa.class);
        Root<Tarefa> root = criteriaQuery.from(Tarefa.class);
        Predicate queryPredicate = getSearchProductsPredicate(root, concluida, termo);

        criteriaQuery.where(queryPredicate);
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("titulo")));
        TypedQuery<Tarefa> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        Long productsCount = getSearchProductsCount(termo, concluida);
        Page<Tarefa> result = new PageImpl<>(query.getResultList(), pageable, productsCount);
        log.info("[Finaliza] TarefaInfraRepository - pesquisarTarefa()");
        return result;
    }

    private Predicate getSearchProductsPredicate(Root<Tarefa> root, String concluida, String term){
        Predicate tituloPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("titulo")), "%" + term.toLowerCase() + "%");
        Predicate descricaoPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")), "%" + term.toLowerCase() + "%");
        Predicate orPredicate = criteriaBuilder.or(tituloPredicate, descricaoPredicate);
        Predicate deletedPredicate = criteriaBuilder.equal(root.get("deletada"), false);

        if (concluida.equals("true")) {
            Predicate concluidaPredicate = criteriaBuilder.equal(root.get("concluida"), true);
            return criteriaBuilder.and(orPredicate, concluidaPredicate, deletedPredicate);
        }
        return criteriaBuilder.and(orPredicate, deletedPredicate);
    }

    private Long getSearchProductsCount(String termo, String concluida) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Tarefa> countRoot = countQuery.from(Tarefa.class);
        Predicate predicate = getSearchProductsPredicate(countRoot, concluida, termo);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }

    @Override
    public Tarefa buscarTarefaPorIdentificador(UUID identificador) {
        log.info("[Inicia]: TarefaInfraRepository - buscarTarefaPorIdentificador()");
        Tarefa tarefa = tarefaJPARepository.findByIdentificadorAndDeletadaFalseOrderByCriadaEmAsc(identificador).orElseThrow(
                () -> {
                       log.error("Tarefa não encontrada! Aplicação encerrada.");
                       return new APIException("Tarefa não encontrada!", HttpStatus.NOT_FOUND);
                }
        );
        log.info("[Finaliza]: TarefaInfraRepository - buscarTarefaPorIdentificador()");
        return tarefa;
    }
}
