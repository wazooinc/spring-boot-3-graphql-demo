package com.example.springboot3graphqldemo.controllers;

import com.example.springboot3graphqldemo.models.Author;
import com.example.springboot3graphqldemo.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRepository authorRepository;

    // function name needs to match what is defined in the
    // graphql schema
    @QueryMapping
    public Iterable<Author> authors() {
        return authorRepository.findAll();
    }

    // @argument annotation, not traditional @PathVariable
    @QueryMapping
    public Optional<Author> authorById(@Argument Long id) {
        return authorRepository.findById(id);
    }


}
