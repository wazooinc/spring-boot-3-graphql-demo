package com.example.springboot3graphqldemo.repositories;

import com.example.springboot3graphqldemo.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
