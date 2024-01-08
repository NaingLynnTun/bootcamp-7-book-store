package org.example.bookshop.dao;

import org.example.bookshop.entity.Book;
import org.example.bookshop.entity.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, BookId> {
}
