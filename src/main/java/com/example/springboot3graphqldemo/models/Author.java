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
public class Author {

    @Id
    @GeneratedValue
    Long id;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Article> articles = new ArrayList<>();
}
