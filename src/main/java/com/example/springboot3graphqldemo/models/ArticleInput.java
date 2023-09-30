package com.example.springboot3graphqldemo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleInput {
    String title;
    String content;
    Long authorId;
}
