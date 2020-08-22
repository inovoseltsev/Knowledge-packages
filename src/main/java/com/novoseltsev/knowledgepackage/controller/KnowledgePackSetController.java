package com.novoseltsev.knowledgepackage.controller;

import com.novoseltsev.knowledgepackage.domain.mapper.KnowledgePackSetMapper;
import com.novoseltsev.knowledgepackage.service.KnowledgePackService;
import com.novoseltsev.knowledgepackage.service.KnowledgePackSetService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KnowledgePackSetController {

    @Autowired
    private KnowledgePackSetService knowledgePackSetService;

    @Autowired
    private KnowledgePackService knowledgePackService;

    @GetMapping("/sets")
    public String getAll(Model model) {
        model.addAttribute("sets", knowledgePackSetService.findAll());
        model.addAttribute("kpacs", knowledgePackService.findAll());
        return "set";
    }

    @GetMapping("/set/{id}")
    public String getPacsBySetId(@PathVariable Long id, Model model) {
        model.addAttribute("kpacs", knowledgePackService.findAllBySetId(id));
        model.addAttribute("setId", id);
        return "set-pacs";
    }

    @PostMapping("/sets")
    public String createSet(@RequestParam Map<String, String> params) {
        knowledgePackSetService.create(new KnowledgePackSetMapper(params)
                .toKnowledgePackSet());
        return "redirect:/sets";
    }

    @GetMapping("/sets/deletion/{id}")
    public String deleteById(@PathVariable Long id) {
        knowledgePackSetService.deleteById(id);
        return "redirect:/sets";
    }
}
