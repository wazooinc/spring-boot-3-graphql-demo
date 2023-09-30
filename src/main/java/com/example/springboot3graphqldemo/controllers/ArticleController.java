package com.example.springboot3graphqldemo.controllers;


import com.example.springboot3graphqldemo.models.Article;
import com.example.springboot3graphqldemo.models.ArticleInput;
import com.example.springboot3graphqldemo.models.Author;
import com.example.springboot3graphqldemo.repositories.ArticleRepository;
import com.example.springboot3graphqldemo.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;

    @QueryMapping
    public Iterable<Article> articles() {
        return articleRepository.findAll();
    }

    @MutationMapping
    public Article createArticle(@Argument String title, @Argument String content, @Argument Long authorId) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new IllegalArgumentException("author not found"));

        Article article = Article
                .builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

        return articleRepository.save(article);
    }

    @MutationMapping
    public Article addArticle(@Argument(name = "article") ArticleInput articleInput) {
        Author author = authorRepository.findById(articleInput.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("author not found"));

        Article article = Article
                .builder()
                .title(articleInput.getTitle())
                .content(articleInput.getContent())
                .author(author)
                .build();

        return articleRepository.save(article);
    }

    @MutationMapping
    public Article updateArticle(@Argument Long id, @Argument(name = "article") ArticleInput articleInput) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("article not found"));

        article.setTitle(articleInput.getTitle());
        article.setContent(articleInput.getContent());
        return articleRepository.save(article);
    }

    @MutationMapping
    public void deleteArticle(@Argument Long id) {
        articleRepository.deleteById(id);
    }

}
