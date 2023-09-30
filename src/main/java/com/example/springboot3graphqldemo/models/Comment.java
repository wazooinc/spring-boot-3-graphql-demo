package com.example.springboot3graphqldemo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Data
@ToString
public class Comment {

    @Id
    @GeneratedValue
    Long id;

    String message;

    @ManyToOne(fetch = FetchType.LAZY)
    Article article;
}
