package com.novoseltsev.knowledgepackage.controller;

import com.novoseltsev.knowledgepackage.domain.entity.KnowledgePack;
import com.novoseltsev.knowledgepackage.domain.mapper.KnowledgePackMapper;
import com.novoseltsev.knowledgepackage.service.KnowledgePackService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/kpacs")
public class KnowledgePackController {

    @Autowired
    private KnowledgePackService knowledgePackService;

    @GetMapping
    public String knowledgePack(Model model) {
        model.addAttribute("kpacs", knowledgePackService.findAll());
        return "index";
    }

    @PostMapping
    public String create(@RequestParam Map<String, String> params) {
        knowledgePackService.create(new KnowledgePackMapper(params)
                .toKnowledgePack());
        return "redirect:/kpacs";
    }

    @PostMapping("/set/{setId}")
    public String createToSet(@PathVariable Long setId,
                              @RequestParam Map<String, String> params) {
        KnowledgePack knowledgePack = new KnowledgePackMapper(params)
                .toKnowledgePack();
        knowledgePack.getPackSetIdList().add(setId);
        knowledgePackService.create(knowledgePack);
        return "redirect:/set/" + setId;
    }

    @GetMapping("/deletion/{id}")
    public String deleteById(@PathVariable Long id) {
        knowledgePackService.deleteById(id);
        return "redirect:/kpacs";
    }

    @GetMapping("/{id}/deletion-from/set/{setId}")
    public String deleteFromSet(@PathVariable Long id,
                                @PathVariable Long setId) {
        knowledgePackService.deleteFromSetById(id, setId);
        return "redirect:/set/" + setId;
    }
}
