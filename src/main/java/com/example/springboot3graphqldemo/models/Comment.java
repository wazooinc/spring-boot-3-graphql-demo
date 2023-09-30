package com.example.springboot3graphqldemo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue
    Long id;

    String message;

    @ManyToOne(fetch = FetchType.LAZY)
    Article article;
}
