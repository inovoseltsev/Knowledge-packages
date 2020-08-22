package com.novoseltsev.knowledgepackage.repository.impl;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePackSet;
import com.novoseltsev.knowledgepackage.repository.KnowledgePackSetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class KnowledgePackSetRepositoryImpl implements KnowledgePackSetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(KnowledgePackSet knowledgePackSet) {
        String title = knowledgePackSet.getTitle();
        String createSetQuery = "insert into k_pac_set (title) values (?)";
        jdbcTemplate.update(createSetQuery, title);
        KnowledgePackSet lastSet = findLast();
        String createPackSetQuery = "insert into k_pac_k_pac_set (k_pac_set_id, "
                + "k_pac_id) values (?, ?)";
        knowledgePackSet.getPackageIdList().forEach(packId -> jdbcTemplate
                .update(createPackSetQuery, lastSet.getId(), packId));
    }

    @Override
    public void deleteById(Long id) {
        String query = "delete from k_pac_set where id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public KnowledgePackSet findLast() {
        String query = "select * from k_pac_set order by id desc limit 1";
        return jdbcTemplate.queryForObject(query,
                new BeanPropertyRowMapper<>(KnowledgePackSet.class));
    }

    @Override
    public List<KnowledgePackSet> findAll() {
        String query = "select * from k_pac_set";
        return jdbcTemplate.query(query,
                new BeanPropertyRowMapper<>(KnowledgePackSet.class));
    }
}
