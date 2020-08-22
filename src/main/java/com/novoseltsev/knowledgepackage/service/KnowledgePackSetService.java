package com.novoseltsev.knowledgepackage.service;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePackSet;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface KnowledgePackSetService {

    void create(KnowledgePackSet knowledgePackSet);

    void deleteById(Long id);

    List<KnowledgePackSet> findAll();
}
