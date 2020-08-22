package com.novoseltsev.knowledgepackage.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class KnowledgePackSet {

    private Long id;
    private String title;
    private List<Long> packageIdList = new ArrayList<>();

    public KnowledgePackSet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Long> getPackageIdList() {
        return packageIdList;
    }

    public void setPackageIdList(List<Long> packageIdList) {
        this.packageIdList = packageIdList;
    }
}
