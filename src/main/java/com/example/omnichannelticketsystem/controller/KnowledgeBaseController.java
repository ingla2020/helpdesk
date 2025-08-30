package com.example.omnichannelticketsystem.controller;

import com.example.omnichannelticketsystem.domain.KnowledgeBaseArticle;
import com.example.omnichannelticketsystem.service.KnowledgeBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/knowledge-base")
public class KnowledgeBaseController {

    private final KnowledgeBaseService knowledgeBaseService;

    public KnowledgeBaseController(KnowledgeBaseService knowledgeBaseService) {
        this.knowledgeBaseService = knowledgeBaseService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("articles", knowledgeBaseService.getAllArticles());
        return "knowledge-base/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("article", new KnowledgeBaseArticle());
        return "knowledge-base/form";
    }

    @PostMapping
    public String create(KnowledgeBaseArticle article) {
        knowledgeBaseService.createArticle(article);
        return "redirect:/knowledge-base";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
        model.addAttribute("article", knowledgeBaseService.getArticleById(id));
        return "knowledge-base/view";
    }
}
