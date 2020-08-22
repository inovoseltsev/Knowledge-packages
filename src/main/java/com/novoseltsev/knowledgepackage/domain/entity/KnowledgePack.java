package com.novoseltsev.knowledgepackage.domain.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KnowledgePack {

    private Long id;
    private String title;
    private String description;
    private String creationDate;
    private List<Long> packSetIdList = new ArrayList<>();

    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("dd-MM-yyyy");

    public KnowledgePack() {
        this.creationDate = DATE_FORMAT.format(new Date());
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<Long> getPackSetIdList() {
        return packSetIdList;
    }

    public void setPackSetIdList(List<Long> packSetIdList) {
        this.packSetIdList = packSetIdList;
    }
}
