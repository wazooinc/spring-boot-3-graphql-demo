package com.example.springboot3graphqldemo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
public class Article {

    @Id
    @GeneratedValue
    Long id;

    String title;

    String content;

    @ManyToOne(fetch = FetchType.LAZY)
    Author author;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    List<Comment> comments = new ArrayList<>();
}
