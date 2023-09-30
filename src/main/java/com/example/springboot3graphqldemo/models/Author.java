package com.example.springboot3graphqldemo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue
    Long id;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Article> articles = new ArrayList<>();
}
