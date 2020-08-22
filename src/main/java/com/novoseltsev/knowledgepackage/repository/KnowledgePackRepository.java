package com.novoseltsev.knowledgepackage.repository;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePack;
import java.util.Collection;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowledgePackRepository {

    void save(KnowledgePack knowledgePack);

    void deleteById(Long id);

    void deleteFromSetById(Long packId, Long setId);

    KnowledgePack findLast();

    Collection<KnowledgePack> findAll();

    Collection<KnowledgePack> findAllBySetId(Long setId);
}
