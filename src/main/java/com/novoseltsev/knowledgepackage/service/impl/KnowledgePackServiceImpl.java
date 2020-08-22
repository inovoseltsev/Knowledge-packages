package com.novoseltsev.knowledgepackage.service.impl;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePack;
import com.novoseltsev.knowledgepackage.repository.KnowledgePackRepository;
import com.novoseltsev.knowledgepackage.service.KnowledgePackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class KnowledgePackServiceImpl implements KnowledgePackService {

    @Autowired
    KnowledgePackRepository knowledgePackRepository;

    @Override
    @Transactional
    public void create(KnowledgePack knowledgePack) {
        knowledgePackRepository.save(knowledgePack);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        knowledgePackRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteFromSetById(Long packId, Long setId) {
        knowledgePackRepository.deleteFromSetById(packId, setId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<KnowledgePack> findAll() {
        return (List<KnowledgePack>) knowledgePackRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<KnowledgePack> findAllBySetId(Long id) {
        return (List<KnowledgePack>) knowledgePackRepository.findAllBySetId(id);
    }
}
