package com.novoseltsev.knowledgepackage.service.impl;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePackSet;
import com.novoseltsev.knowledgepackage.repository.KnowledgePackSetRepository;
import com.novoseltsev.knowledgepackage.service.KnowledgePackService;
import com.novoseltsev.knowledgepackage.service.KnowledgePackSetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KnowledgePackSetServiceImpl implements KnowledgePackSetService {

    @Autowired
    private KnowledgePackSetRepository knowledgePackSetRepository;

    @Autowired
    KnowledgePackService knowledgePackService;

    @Override
    @Transactional
    public void create(KnowledgePackSet knowledgePackSet) {
        knowledgePackSetRepository.save(knowledgePackSet);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        knowledgePackSetRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KnowledgePackSet> findAll() {
        return (List<KnowledgePackSet>) knowledgePackSetRepository.findAll();
    }
}
