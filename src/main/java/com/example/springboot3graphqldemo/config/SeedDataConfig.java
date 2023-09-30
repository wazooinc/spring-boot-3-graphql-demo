package com.example.springboot3graphqldemo.config;

import com.example.springboot3graphqldemo.models.Article;
import com.example.springboot3graphqldemo.models.Author;
import com.example.springboot3graphqldemo.models.Comment;
import com.example.springboot3graphqldemo.repositories.ArticleRepository;
import com.example.springboot3graphqldemo.repositories.AuthorRepository;
import com.example.springboot3graphqldemo.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SeedDataConfig implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {


        if (authorRepository.count() == 0) {

            Author author1 = Author.builder()
                    .firstName("Jack")
                    .lastName("Pain")
                    .build();

            author1 = authorRepository.save(author1);


            Article article1 = Article.builder()
                    .title("article 1")
                    .content("this is article 1")
                    .author(author1)
                    .build();

            Article article2 = Article.builder()
                    .title("article 2")
                    .content("this is article 2")
                    .author(author1)
                    .build();

            articleRepository.save(article1);
            articleRepository.save(article2);

            Comment comment1 = Comment.builder()
                    .message("great article")
                    .article(article1)
                    .build();

            Comment comment2 = Comment.builder()
                    .message("good article")
                    .article(article2)
                    .build();

            commentRepository.save(comment1);
            commentRepository.save(comment2);

        }
    }

}
