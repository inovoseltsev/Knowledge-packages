package com.novoseltsev.knowledgepackage.domain.mapper;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePack;
import java.util.Map;

public class KnowledgePackMapper {

    private Map<String, String> params;

    public KnowledgePackMapper(Map<String, String> params) {
        this.params = params;
    }

    public KnowledgePack toKnowledgePack() {
        KnowledgePack knowledgePack = new KnowledgePack();
        String id = params.get("id");
        if (id != null) {
            knowledgePack.setId(Long.valueOf(id));
        }
        knowledgePack.setTitle(params.get("title"));
        knowledgePack.setDescription(params.get("description"));
        return knowledgePack;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
