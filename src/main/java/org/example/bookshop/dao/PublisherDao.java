package org.example.bookshop.dao;

import org.example.bookshop.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherDao extends JpaRepository<Publisher,Integer> {
}
