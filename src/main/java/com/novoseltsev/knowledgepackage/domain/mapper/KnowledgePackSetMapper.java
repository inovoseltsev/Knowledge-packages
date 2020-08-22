package com.novoseltsev.knowledgepackage.domain.mapper;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePackSet;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class KnowledgePackSetMapper {

    private Map<String, String> params;

    public KnowledgePackSetMapper(Map<String, String> params) {
        this.params = params;
    }

    public KnowledgePackSet toKnowledgePackSet() {
        KnowledgePackSet knowledgePackSet = new KnowledgePackSet();
        String id = params.get("id");
        String pacsId = params.get("packIdList");
        if (id != null) {
            knowledgePackSet.setId(Long.valueOf(id));
        }
        if (!"".equals(pacsId)) {
            knowledgePackSet.setPackageIdList(Arrays.stream(pacsId.split(","))
                    .map(Long::valueOf).collect(Collectors.toList()));
        }
        knowledgePackSet.setTitle(params.get("title"));
        return knowledgePackSet;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
