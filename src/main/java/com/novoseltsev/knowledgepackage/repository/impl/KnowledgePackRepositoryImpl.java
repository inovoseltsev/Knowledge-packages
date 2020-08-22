package com.novoseltsev.knowledgepackage.repository.impl;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePack;
import com.novoseltsev.knowledgepackage.repository.KnowledgePackRepository;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackRepositoryImpl implements KnowledgePackRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(KnowledgePack knowledgePack) {
        String title = knowledgePack.getTitle();
        String description = knowledgePack.getDescription();
        String creationDate = knowledgePack.getCreationDate();
        String createPackQuery = "insert into k_pac(title, description,"
                + "creation_date) values (?, ?, ?)";
        jdbcTemplate.update(createPackQuery, title, description, creationDate);
        KnowledgePack lastPack = findLast();
        String createPackSetQuery = "insert into k_pac_k_pac_set (k_pac_set_id, "
                + "k_pac_id) values (?, ?)";
        knowledgePack.getPackSetIdList().forEach(setId -> jdbcTemplate
                .update(createPackSetQuery, setId, lastPack.getId()));
    }

    @Override
    public void deleteById(Long id) {
        String query = "delete from k_pac where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public void deleteFromSetById(Long packId, Long setId) {
        String query = "delete from k_pac_k_pac_set where k_pac_id = ? and "
                + "k_pac_set_id = ?";
        jdbcTemplate.update(query, packId, setId);
    }

    @Override
    public KnowledgePack findLast() {
        String query = "select * from k_pac order by id desc limit 1";
        return jdbcTemplate.queryForObject(query,
                new BeanPropertyRowMapper<>(KnowledgePack.class));
    }

    @Override
    public Collection<KnowledgePack> findAll() {
        String query = "select * from k_pac order by id";
        return jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(KnowledgePack.class));
    }

    @Override
    public List<KnowledgePack> findAllBySetId(Long setId) {
        String query = "select * from k_pac join k_pac_k_pac_set kps on "
                + "kps.k_pac_id = id where kps.k_pac_set_id = ?";
        return jdbcTemplate.query(query, new Object[]{setId},
                new BeanPropertyRowMapper<>(KnowledgePack.class));
    }
}
