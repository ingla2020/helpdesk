package com.example.omnichannelticketsystem.service;

import com.example.omnichannelticketsystem.domain.KnowledgeBaseArticle;
import com.example.omnichannelticketsystem.repository.KnowledgeBaseArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KnowledgeBaseService {

    private final KnowledgeBaseArticleRepository repository;

    public KnowledgeBaseService(KnowledgeBaseArticleRepository repository) {
        this.repository = repository;
    }

    public List<KnowledgeBaseArticle> getAllArticles() {
        return repository.findAll();
    }

    public KnowledgeBaseArticle getArticleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public KnowledgeBaseArticle createArticle(KnowledgeBaseArticle article) {
        article.setCreatedAt(LocalDateTime.now());
        return repository.save(article);
    }
}
