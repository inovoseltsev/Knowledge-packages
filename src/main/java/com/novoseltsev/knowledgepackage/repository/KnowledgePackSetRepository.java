package com.novoseltsev.knowledgepackage.repository;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePackSet;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgePackSetRepository {

    void save(KnowledgePackSet knowledgePackSet);

    void deleteById(Long id);

    KnowledgePackSet findLast();

    Collection<KnowledgePackSet> findAll();
}
