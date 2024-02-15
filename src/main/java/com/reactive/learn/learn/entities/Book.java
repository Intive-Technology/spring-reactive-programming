package com.reactive.learn.learn.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("books")
public class Book {
    @Id
    private int id;

    private String name;

    private String description;
    private String publisher;
    private String author;

    
}
