package org.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@IdClass(BookId.class)
@NoArgsConstructor
public class Book implements Serializable {
    @Id
    private int id;
    @Id
    private String isbn;
    private String title;
    private String description;
    private double price;
    private int stock;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

    public void addGeneres(Genre genre){
        genre.getBooks().add(this);
        genres.add(genre);
    }

    @OneToMany(mappedBy = "book")
    private List<OrderItem> orderItems = new ArrayList<>();

    // utilites
    public void addOrderItem(OrderItem orderItem){
        orderItem.setBook(this);
        orderItems.add(orderItem);
    }

    // Constructors
    public Book(int id, String isbn, String title, String description, double price, int stock) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }
}
