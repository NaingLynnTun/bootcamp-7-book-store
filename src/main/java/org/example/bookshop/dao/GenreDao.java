package org.example.bookshop.dao;

import org.example.bookshop.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<Genre,Integer> {
}
