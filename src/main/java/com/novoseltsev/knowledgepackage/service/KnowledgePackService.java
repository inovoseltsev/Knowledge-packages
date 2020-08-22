package com.novoseltsev.knowledgepackage.service;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePack;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface KnowledgePackService {

    void create(KnowledgePack knowledgePack);

    void deleteById(Long id);

    void deleteFromSetById(Long packId, Long setId);

    List<KnowledgePack> findAll();

    List<KnowledgePack> findAllBySetId(Long id);
}
