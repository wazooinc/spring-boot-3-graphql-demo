package com.example.springboot3graphqldemo.repositories;

import com.example.springboot3graphqldemo.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
