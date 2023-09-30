package com.example.springboot3graphqldemo.repositories;

import com.example.springboot3graphqldemo.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
