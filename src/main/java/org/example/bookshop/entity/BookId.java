package org.example.bookshop.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookId implements Serializable {

    private int id;
    private String isbn;
}
