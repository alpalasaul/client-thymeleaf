package com.programacion.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
//    private static final Long serialVersionUID = 1L;
    private int id;
    private String isbn;
//    private Author author;
    private String title;
    private double price;
}
